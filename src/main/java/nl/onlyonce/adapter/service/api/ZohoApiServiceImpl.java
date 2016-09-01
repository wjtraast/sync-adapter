package nl.onlyonce.adapter.service.api;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.zoho.ErrorResponse;
import nl.onlyonce.adapter.model.zoho.ZohoAccount;
import nl.onlyonce.adapter.model.zoho.ZohoContact;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author: Gerben
 */

@Service
@Log
public class ZohoApiServiceImpl implements ZohoApiService {

    private static final String TOKEN = "4c988532184e4a039ede895c7383c450";

    @Override
    public void insertContact(final ZohoContact contact) throws RuntimeException, ZohoApiException {

        try {
            String xmlString = convertToString(contact, ZohoContact.class);
            String response = postRequest(ZoHoApiConfiguration.Endpoints.Contact.INSERT_RECORDS, xmlString);
            log.info("The Response from the server : " + response);
            if (response.contains("<error>")) {
                ErrorResponse errorResponse = convertToXml(response);
                throw new ZohoApiException(errorResponse.getError().getCode(), errorResponse.getError().getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }



        /* do some exception handling ... throw exception when soemthing is wrong */
    }

    private ErrorResponse convertToXml(String xmlString) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(ErrorResponse.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xmlString);
        return (ErrorResponse) unmarshaller.unmarshal(reader);
    }

    @Override
    public void insertAccount(final ZohoAccount account) throws RuntimeException, ZohoApiException {

        try {
            String xmlString = convertToString(account, ZohoAccount.class);
            String response = postRequest(ZoHoApiConfiguration.Endpoints.Account.INSERT_RECORDS, xmlString);
            log.info("The Response from the server : " + response);
            if (response.contains("<error>")) {
                ErrorResponse errorResponse = convertToXml(response);
                throw new ZohoApiException(errorResponse.getError().getCode(), errorResponse.getError().getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    private String postRequest(final String url, final String xmlString) throws Exception {
        String targetURL = ZoHoApiConfiguration.ENDPOINT + url;
        PostMethod post = new PostMethod(targetURL);
        post.setParameter("authtoken", TOKEN);
        post.setParameter("scope", ZoHoApiConfiguration.SCOPE);
        post.setParameter("newFormat", ZoHoApiConfiguration.NEWFORMAT);
        post.setParameter("xmlData", xmlString);
        HttpClient httpclient = new HttpClient();
        httpclient.executeMethod(post);
        return post.getResponseBodyAsString();
    }

    private String convertToString(final Object xmlObject, Class clazz) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(xmlObject, sw);
        return sw.toString();
    }
}
