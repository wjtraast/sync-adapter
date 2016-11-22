package nl.onlyonce.adapter.service.api;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.ApplicationProperties;
import nl.onlyonce.adapter.model.zoho.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

/**
 * @author: Gerben
 */

@Service
@Log
public class ZohoApiServiceImpl implements ZohoApiService {

    //private static final String ZOHO_API_TOKEN = "4c988532184e4a039ede895c7383c450";

    @Autowired
    ApplicationProperties applicationConfiguration;

    @Override
    public void insertContact(final ZohoContact contact) throws RuntimeException, ZohoApiException {

        try {
            String xmlString = convertToString(contact, ZohoContact.class);
            String response = postRequest(ZoHoApiConfiguration.Endpoints.Contact.INSERT_RECORDS, xmlString, null);
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

    private List<ZohoContact> convertContactsToXml(String xmlString) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(ZohoContactSearchResponse.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xmlString);

        ZohoContactSearchResponse response = (ZohoContactSearchResponse) unmarshaller.unmarshal(reader);
        ZohoContactSearchResult result = response.getResult();
        if (result == null) {
            return null;
        }
        return result.getContacts();
    }

    @Override
    public void insertAccount(final ZohoAccount account) throws RuntimeException, ZohoApiException {

        try {
            String xmlString = convertToString(account, ZohoAccount.class);
            String response = postRequest(ZoHoApiConfiguration.Endpoints.Account.INSERT_RECORDS, xmlString, null);
            log.info("The Response from the server : " + response);
            if (response.contains("<error>")) {
                ErrorResponse errorResponse = convertToXml(response);
                throw new ZohoApiException(errorResponse.getError().getCode(), errorResponse.getError().getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    @Override
    public ZohoContact findContact(final String emailAddress, final String cardId) throws RuntimeException, ZohoApiException {

        try {

            String targetURL = applicationConfiguration.getZohoUrl() + ZoHoApiConfiguration.Endpoints.Contact.GET_SEARCH_RECORSDS_BY_PDC;
            GetMethod get = new GetMethod(targetURL);
            NameValuePair param1 = new NameValuePair("authtoken", applicationConfiguration.getZohoToken());
            NameValuePair param2 = new NameValuePair("scope", ZoHoApiConfiguration.SCOPE);
            NameValuePair param3 = new NameValuePair("searchColumn", "email");
            NameValuePair param4 = new NameValuePair("searchValue", emailAddress);
            NameValuePair param5 = new NameValuePair("newFormat", ZoHoApiConfiguration.NEWFORMAT);
            NameValuePair[] params = new NameValuePair[] {param1, param2, param3, param4, param5};
            HttpClient httpclient = new HttpClient();
            get.setQueryString(params);
            httpclient.executeMethod(get);

            String responseBody = get.getResponseBodyAsString();
            List<ZohoContact> contacts = convertContactsToXml(responseBody);
            if (contacts == null) {
                return null;
            }

            ZohoContact foundContact = null;
            for (ZohoContact zohoContact : contacts) {
                List<ZohoField> fields =  zohoContact.getFieldList().getFields();
                boolean cardFound = false;
                for (ZohoField field : fields) {
                    if (ZohoFieldNames.Contact.Custom.CONTACTCF1.equals(field.getLabel()) && field.getValue().equalsIgnoreCase(cardId)) {
                        cardFound = true;
                    }
                }

                if (cardFound) {
                    for (ZohoField field : fields) {
                        if (ZohoFieldNames.Contact.EMAIL1.equals(field.getLabel()) && field.getValue().equalsIgnoreCase(emailAddress)) {
                            foundContact = zohoContact;
                            break;
                        }
                    }
                }
            }
            return foundContact;
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    @Override
    public void updateContact(ZohoContact contact) throws HttpException, ZohoApiException {
        try {
            String xmlString = convertToString(contact, ZohoContact.class);
            String response = postRequest(ZoHoApiConfiguration.Endpoints.Contact.UPDATE_RECORDS, xmlString, contact.getFieldList().getFieldByName(ZohoFieldNames.Contact.CONTACTID).getValue());
            log.info("The Response from the server : " + response);
            if (response.contains("<error>")) {
                ErrorResponse errorResponse = convertToXml(response);
                throw new ZohoApiException(errorResponse.getError().getCode(), errorResponse.getError().getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    private String postRequest(final String url, final String xmlString, final String id) throws Exception {
        String targetURL = applicationConfiguration.getZohoUrl() + url;
        PostMethod post = new PostMethod(targetURL);
        post.setParameter("authtoken", applicationConfiguration.getZohoToken());
        post.setParameter("scope", ZoHoApiConfiguration.SCOPE);
        post.setParameter("newFormat", ZoHoApiConfiguration.NEWFORMAT);
        post.setParameter("xmlData", xmlString);
        if (id != null) {
            post.setParameter("id", id);
        }
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
