package nl.onlyonce.adapter.model.zoho;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Gerben
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ZohoRow implements Serializable {

    @XmlElement(name= "FL")
    List<ZohoField> zohoFields;


    public void setZohoFields(List<ZohoField> zohoFields) {
        this.zohoFields = zohoFields;
    }

    public List<ZohoField> getZohoFields() {
        return zohoFields;
    }


    public static ZohoField getFieldByName(ZohoRow zohoRow, String fieldName) {

        for (ZohoField field : zohoRow.getZohoFields()) {
            if (field.getLabel().equalsIgnoreCase(fieldName)) {
                return field;
            }
        }
        return null;
    }
}
