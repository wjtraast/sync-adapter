package nl.onlyonce.adapter.model.zoho;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author: Gerben
 */

public class ZohoField {

    private String label;
    private String value;

    public ZohoField() {

    }

    public ZohoField(String label, String value) {
        this.label = label;
        this.value = value;
    }


    @XmlAttribute(name = "val")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue (String value) {
        this.value = value;
    }
}
