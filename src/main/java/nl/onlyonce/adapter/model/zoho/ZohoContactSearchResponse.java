package nl.onlyonce.adapter.model.zoho;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: Gerben
 */
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZohoContactSearchResponse {

    @XmlElement(name = "response uri")
    private String responseUri;

    @XmlElement(name = "result")
    private ZohoContactSearchResult result;


    public ZohoContactSearchResult getResult() {
        return result;
    }

    public void setResult(ZohoContactSearchResult result) {
        this.result = result;
    }

    public String getResponseUri() {
        return responseUri;
    }

    public void setResponseUri(String responseUri) {
        this.responseUri = responseUri;
    }
}
