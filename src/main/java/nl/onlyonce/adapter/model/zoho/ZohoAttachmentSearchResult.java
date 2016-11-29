package nl.onlyonce.adapter.model.zoho;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: Gerben
 */

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZohoAttachmentSearchResult {

    @XmlElement(name = "Attachments")
    private ZohoAttachments attachments = null;

    public ZohoAttachments getAttachments() {
        return attachments;
    }

    public void setAttachments(ZohoAttachments attachments) {
        this.attachments = attachments;
    }
}
