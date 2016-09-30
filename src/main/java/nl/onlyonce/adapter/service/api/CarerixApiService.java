package nl.onlyonce.adapter.service.api;

import com.carerix.api.CREmployee;
import com.carerix.api.CRUser;
import nl.onlyonce.adapter.model.carerix.CarerixNodeType;
import org.w3c.dom.Document;

/**
 * @author: Gerben
 */
public interface CarerixApiService {

    Document addEmployee(CREmployee employee);

    Document updateEmployee(String id, CREmployee employee);


    String findEmployee(String cardId);


    String findIdForValue(CarerixNodeType type, String value);


    void updateUser(String userId, CRUser user);

    Document getEmployee(String employeeId);

}
