package nl.onlyonce.adapter.model.zoho;

import javax.xml.bind.annotation.*;

/**
 * @author: Gerben
 */
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZohoAttachmentSearchResponse {

//    @XmlAttribute(name = "uri")
//    private String responseUri;

    @XmlElement(name = "result")
    private ZohoAttachmentSearchResult result;


    public ZohoAttachmentSearchResult getResult() {
        return result;
    }

    public void setResult(ZohoAttachmentSearchResult result) {
        this.result = result;
    }
//
//    public String getResponseUri() {
//        return responseUri;
//    }
//
//    public void setResponseUri(String responseUri) {
//        this.responseUri = responseUri;
//    }
}
