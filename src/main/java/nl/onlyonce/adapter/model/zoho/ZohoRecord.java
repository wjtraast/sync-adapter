package nl.onlyonce.adapter.model.zoho;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * @author: Gerben
 */
public class ZohoRecord implements Serializable {

    private FieldList fieldList;

    public ZohoRecord () {
        this.fieldList = new FieldList(1L);
    }

    public FieldList getFieldList() {
        return fieldList;
    }

    @XmlElement(name = "row")
    public void setFieldList(FieldList fieldList) {
        this.fieldList = fieldList;
    }


    protected void addField(String label, String value) {
        this.fieldList.addField(label, value);
    }



}
