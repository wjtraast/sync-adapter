package nl.onlyonce.adapter.model.zoho;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author: Gerben
 */

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZohoContactSearchResult {

    @XmlElement(name = "Contacts")
    private List<ZohoContact> contacts = null;

    public List<ZohoContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<ZohoContact> contacts) {
        this.contacts = contacts;
    }
}
