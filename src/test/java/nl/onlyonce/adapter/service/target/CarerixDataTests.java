package nl.onlyonce.adapter.service.target;

import com.carerix.api.CREmployeeType;
import org.junit.Test;

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
}
