package nl.onlyonce.adapter.service.target;

import com.carerix.api.CREmployeeType;
import nl.onlyonce.adapter.model.carerix.CarerixModel;
import nl.onlyonce.adapter.service.utils.XMLUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @author: Gerben
 */
public class CarerixDataTests {

    @Test
    public void testCREmployeeTypeToString() throws Exception {

        CREmployeeType type = new CREmployeeType();
        type.setFirstName("Jan");
        type.setLastName("Jansen");

        String result = TestUtils.convertEmployeeToString(type);

        System.out.println(result);

    }

    @Test
    public void testParseEmployee() throws Exception {


        String data = IOUtils.toString(this.getClass().getResourceAsStream("/carerix/CREmployeeGetResult.xml"), "UTF-8");
        Document employeeDocument = XMLUtils.parseXml(data);
        String id = employeeDocument.getElementsByTagName(CarerixModel.ELEMENTS.CREMPLOYEE).item(0).getAttributes().getNamedItem("id").getNodeValue();











    }
}
