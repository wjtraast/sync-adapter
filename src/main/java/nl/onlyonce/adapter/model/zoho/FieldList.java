package nl.onlyonce.adapter.model.zoho;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gerben
 */
public class FieldList {

    List<ZohoField> fields;

    Long rowNumber;

    public FieldList(Long rowNumber) {
        fields = new ArrayList<>();
        this.rowNumber = rowNumber;
    }

    @XmlElement(name = "FL")
    public List<ZohoField> getFields(){
        return fields;
    }

    @XmlAttribute(name="no")
    public Long getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Long rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void addField(String label, String value) {
        ZohoField zohoField = new ZohoField(label, value);
        this.getFields().add(zohoField);

    }
}
