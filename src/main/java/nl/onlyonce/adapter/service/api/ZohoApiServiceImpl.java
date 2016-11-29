package nl.onlyonce.adapter.service.api;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.ApplicationProperties;
import nl.onlyonce.adapter.model.message.ResumeWrapper;
import nl.onlyonce.adapter.model.zoho.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Gerben
 */

@Service
@Log
public class ZohoApiServiceImpl implements ZohoApiService {

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

    private ZohoAttachments convertAttachmentsToXml(String xmlString) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(ZohoAttachmentSearchResponse.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xmlString);

        ZohoAttachmentSearchResponse response = (ZohoAttachmentSearchResponse) unmarshaller.unmarshal(reader);
        ZohoAttachmentSearchResult result = response.getResult();
        if (result == null) {
            return null;
        }
        return result.getAttachments();
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

    private void insertAttachment(final String contactId, final String documentId, final String filename, final String base64) throws HttpException, ZohoApiException {

        String targetURL = applicationConfiguration.getZohoUrl() + ZoHoApiConfiguration.Endpoints.Contact.UPLOAD_FILE;
        targetURL = targetURL + "?authtoken=" + applicationConfiguration.getZohoToken() + "&scope=" + ZoHoApiConfiguration.SCOPE + "&" +
                "id=" + documentId + "&scope=" + ZoHoApiConfiguration.SCOPE;

        byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(base64);
        PartSource ps = new ByteArrayPartSource(documentId + "-" + filename, decoded);
        PostMethod post = new PostMethod(targetURL);
        Part[] fields = {new FilePart("content", ps), new StringPart("id", contactId),};
        post.setRequestEntity(new MultipartRequestEntity(fields, post.getParams()));
        HttpClient httpclient = new HttpClient();
        try {
            httpclient.executeMethod(post);
        } catch (IOException e) {
            throw new HttpException();
        }
    }



    @Override
    public ZohoAttachments findAttachments(String contactId) throws HttpException, ZohoApiException  {
        try {

            String targetURL = applicationConfiguration.getZohoUrl() + ZoHoApiConfiguration.Endpoints.Attachment.GET_RELATED_RECORDS;
            GetMethod get = new GetMethod(targetURL);
            NameValuePair param1 = new NameValuePair("authtoken", applicationConfiguration.getZohoToken());
            NameValuePair param2 = new NameValuePair("scope", ZoHoApiConfiguration.SCOPE);
            NameValuePair param3 = new NameValuePair("id", contactId);
            NameValuePair param4 = new NameValuePair("parentModule", "Contacts");
            NameValuePair param5 = new NameValuePair("newFormat", ZoHoApiConfiguration.NEWFORMAT);
            NameValuePair[] params = new NameValuePair[] {param1, param2, param3, param4, param5};
            HttpClient httpclient = new HttpClient();
            get.setQueryString(params);
            httpclient.executeMethod(get);
            String responseBody = get.getResponseBodyAsString();
            return convertAttachmentsToXml(responseBody);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateAttachments(String contactId, List<ResumeWrapper> resumes) throws HttpException, ZohoApiException {

        if (resumes != null) {
            ZohoAttachments attachments = findAttachments(contactId);

            Map<String, ResumeWrapper> contentMap = new HashMap<>();
            for (ResumeWrapper wrapper : resumes) {
                contentMap.put(wrapper.getId(), wrapper);
            }

            for (String onlyonceId : contentMap.keySet()) {
                ResumeWrapper resume = contentMap.get(onlyonceId);
                if (attachments != null) {

                    ZohoRow zohoRow = getAttachment(attachments, onlyonceId);
                    if (zohoRow == null) {
                        insertAttachment(contactId, onlyonceId, resume.getFilename(), resume.getFileContent());
                    } else {
                        String attachmentId = ZohoRow.getFieldByName(zohoRow, ZohoFieldNames.Attachment.ID).getValue();
                        deleteAtttachment(attachmentId);
                        insertAttachment(contactId, onlyonceId, resume.getFilename(), resume.getFileContent());
                    }
                } else {
                    insertAttachment(contactId, onlyonceId, resume.getFilename(), resume.getFileContent());

                }
            }
        }
    }

    private ZohoRow getAttachment(ZohoAttachments attachments , String onlyOnceId) {
        for (ZohoRow row : attachments.getRows()) {
            String filename = ZohoRow.getFieldByName(row, ZohoFieldNames.Attachment.FILE_NAME).getValue();
            if (filename.startsWith(onlyOnceId)) {
                return row;
            }
        }
        return null;
    }


    private void deleteAtttachment(final String attachmentId) throws HttpException, ZohoApiException {

        try {
            String targetURL = applicationConfiguration.getZohoUrl() + ZoHoApiConfiguration.Endpoints.Contact.DELETE_FILE;
            GetMethod get = new GetMethod(targetURL);
            NameValuePair param1 = new NameValuePair("authtoken", applicationConfiguration.getZohoToken());
            NameValuePair param2 = new NameValuePair("scope", ZoHoApiConfiguration.SCOPE);
            NameValuePair param3 = new NameValuePair("id", attachmentId);
            NameValuePair[] params = new NameValuePair[] {param1, param2, param3};
            HttpClient httpclient = new HttpClient();
            get.setQueryString(params);
            httpclient.executeMethod(get);
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

//    public static void main (String[] args) {
//
//        try {
//            String auth_token = "4c988532184e4a039ede895c7383c450";
//            String auth_scope = "crmapi";
//            String targetURL = "http://localhost:61223";
//            String recordId = "2071060000000152001";
//            String file = "/Users/Gerben/Desktop/my-resume.pages";
//            File f = new File(file);
//            FileInputStream fis = new FileInputStream(f);
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            int c;
//            while ((c = fis.read()) != -1) {
//                bos.write(c);
//            }
//            byte[] fbArray = bos.toByteArray();
//            //targetURL = targetURL + "?authtoken=" + auth_token + "&scope=" + auth_scope;
//            PartSource ps = new ByteArrayPartSource(file, fbArray);
//            PostMethod post = new PostMethod(targetURL);
//            Part[] fields = {new FilePart("content", ps), new StringPart("id", recordId),};
//            post.setRequestEntity(new MultipartRequestEntity(fields, post.getParams()));
//            HttpClient httpclient = new HttpClient();
//            httpclient.executeMethod(post);
//            String postResp = post.getResponseBodyAsString();
//            System.out.println("postResp===========> : " + postResp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
