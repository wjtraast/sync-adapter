package nl.onlyonce.adapter.model.zoho;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author: Gerben
 */
public class Error {

    private String code;
    private String message;


    @XmlElement
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
