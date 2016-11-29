package nl.onlyonce.adapter.model.zoho;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author: Gerben
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ZohoAttachments  {

    @XmlElement(name = "row")
    private List<ZohoRow> rows;

    public void setRows(List<ZohoRow> rows) {
        this.rows = rows;
    }

    public List<ZohoRow> getRows() {
        return rows;
    }









}
