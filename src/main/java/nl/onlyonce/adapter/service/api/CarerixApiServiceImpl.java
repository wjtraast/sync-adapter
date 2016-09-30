package nl.onlyonce.adapter.service.api;

import com.carerix.api.CREmployee;
import com.carerix.api.CRUser;
import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.carerix.CarerixNodeType;
import nl.onlyonce.adapter.service.utils.XMLUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;

import java.io.IOException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static nl.onlyonce.adapter.AppConfig.CARERIX_TOKEN;
import static nl.onlyonce.adapter.AppConfig.CARERIX_USERNAME;

/**
 * @author: Gerben
 */

@Service
@Log
public class CarerixApiServiceImpl implements CarerixApiService {

    private static final java.lang.String MATCH = "<array count=\"1\">";

    @Override
    public CREmployee addEmployee(CREmployee employee) {

        try {
            String result = postRequest(CarerixApiConfiguration.Endpoints.CREMPLOYEE, CarerixModelHelper.convertEmployee(employee));
            Document employeeDocument = XMLUtils.parseXml(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void updateGender(String employeeId, String gender) throws Exception {

        if (!StringUtils.isEmpty(employeeId) && !StringUtils.isEmpty(gender)) {
            String data = CarerixModelHelper.addGenderToEmployee(employeeId, gender);
            postRequest(CarerixApiConfiguration.Endpoints.CREMPLOYEE, data);
        }
    }

    private String postRequest(String endPoint, String data) throws Exception {
        if (!StringUtils.isEmpty(data)) {
            String result = Request.Post(CarerixApiConfiguration.DOMAIN + endPoint)
                    .addHeader("Authorization", "Basic " + getAuthorization())
                    .addHeader("Content-Type", "application/xml")
                    .bodyString(data, ContentType.DEFAULT_TEXT)
                    .execute().returnContent().toString();
            return result;
        }
        return null;
    }


    private String putRequest(String endPoint, String data) throws Exception {
        if (!StringUtils.isEmpty(data)) {
            String result = Request.Put(CarerixApiConfiguration.DOMAIN + endPoint)
                    .addHeader("Authorization", "Basic " + getAuthorization())
                    .addHeader("Content-Type", "application/xml")
                    .bodyString(data, ContentType.DEFAULT_TEXT)
                    .execute().returnContent().toString();
            return result;
        }
        return null;
    }


    private String getRequest(final String endPoint, final String url) throws Exception {
        String result = Request.Get(CarerixApiConfiguration.DOMAIN + endPoint + url)
                .addHeader("Authorization", "Basic " + getAuthorization())
                .addHeader("Content-Type", "application/xml")
                .execute().returnContent().toString();
        return result;
    }


    private String getAuthorization(){
        String authString = CARERIX_USERNAME + ":" + CARERIX_TOKEN;
        return new String(Base64.getEncoder().encode(authString.getBytes()));

    }

    @Override
    public CREmployee getEmployee(final String employeeId) {

//        try {
//            String result = getRequest(CarerixApiConfiguration.Endpoints.CREMPLOYEE, "/" + employeeId);
//            CREmployee employee = CarerixModelHelper.convertEmployee(result);
//            return employee;
//
//        } catch (Exception e) {
//        }
        return null;
    }

    @Override
    public String getEmployeeAsString(String employeeId) {
        try {
            return getRequest(CarerixApiConfiguration.Endpoints.CREMPLOYEE, "/" + employeeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CREmployee updateEmployee(final String id, final CREmployee employee) {
        try {
            String data = CarerixModelHelper.convertEmployee(employee);

            String result = putRequest(CarerixApiConfiguration.Endpoints.CREMPLOYEE + "/" + id ,data);

         //   String dataNodeResult = putRequest(CarerixApiConfiguration.Endpoints.CRDATANODE + "/" + id ,data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String findEmployee(final String cardId) {

        try {
            String result = Request.Get(CarerixApiConfiguration.DOMAIN + CarerixApiConfiguration.Endpoints.CREMPLOYEE +
            "?qualifier=notes%20like%20%27*ref%3D"+ cardId + "*%27")
                    .addHeader("Authorization", "Basic " + getAuthorization())
                    .addHeader("Content-Type", "application/xml")
                    .execute().returnContent().asString();
            if (result.contains(MATCH)) {
                String pattern = "<CREmployee id=\"(\\d*)\">";
                Pattern r = Pattern.compile(pattern);
                Matcher m = r.matcher(result);
                if (m.find( )) {
                    return m.group(1);
                }
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public String getCountry(String nodeId) {
        return null;
    }

    @Override
    public String getGender(String nodeId) {
        return null;
    }

    @Override
    public CRUser getUser(String userId) {
        return null;
    }

    @Override
    public String getLanguage(String nodeId) {
        return null;
    }

    @Override
    public String findIdForValue(CarerixNodeType type, String value) {

        try {
            // https://api.carerix.com/CRDataNode/list-by?type=Opzegtermijn

            String result = Request.Get(CarerixApiConfiguration.DOMAIN + CarerixApiConfiguration.Endpoints.CRDATANODE +
                    "/list-by?language=Dutch&type=" + type.toString())
                    .addHeader("Authorization", "Basic " + getAuthorization())
                    .addHeader("Content-Type", "application/xml")
                    .execute().returnContent().asString();
        return findNodeId(result, value);
        } catch (IOException e) {
            return null;
        }
    }

    private String findNodeId(String result, String value) {

        value = value.replace("\\n", "");
        value = value.replace("\\r", "");
        value = value.replace("\\t", "");
        Document doc = XMLUtils.parseXml(result);


      //  ((DeferredDocumentImpl) doc).item(0).getChildNodes().item(3).getChildNodes().item(19).getFirstChild().getNodeValue()

        for (int i = 0; i < doc.getChildNodes().item(0).getChildNodes().getLength(); i ++) {
            for (int j =0; j<doc.getChildNodes().item(0).getChildNodes().item(i).getChildNodes().getLength(); j ++) {
                if (doc.getChildNodes().item(0).getChildNodes().item(i).getChildNodes().item(j).getFirstChild() != null) {

                    String nodeName = doc.getChildNodes().item(0).getChildNodes().item(i).getChildNodes().item(j).getNodeName();
                    if ("value".equals(nodeName)) {
                        String nodeValue = doc.getChildNodes().item(0).getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue();
                        if (value.equalsIgnoreCase(nodeValue)) {
                            return doc.getChildNodes().item(0).getChildNodes().item(i).getAttributes().getNamedItem("id").getNodeValue();
                        }
                    }
                }
           }
        }
        return null;
    }


    public static void main (String[] args) {

        String line = "<CREmployee id=\"55905\">";
        String pattern = "<CREmployee id=\"(\\d*)\">";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        }else {
            System.out.println("NO MATCH");
        }



    }
}
