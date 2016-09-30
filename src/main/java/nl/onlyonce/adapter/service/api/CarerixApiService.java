package nl.onlyonce.adapter.service.api;

import com.carerix.api.CREmployee;
import com.carerix.api.CRUser;
import nl.onlyonce.adapter.model.carerix.CarerixNodeType;

/**
 * @author: Gerben
 */
public interface CarerixApiService {

    CREmployee addEmployee(CREmployee employee);

    CREmployee getEmployee(String employeeId);

    String getEmployeeAsString(String employeeId);


    CREmployee updateEmployee(String id, CREmployee employee);


    String findEmployee(String cardId);

    String getCountry(String nodeId);

    String getGender(String nodeId);

    CRUser getUser(String userId);

    String getLanguage(String nodeId);

    String findIdForValue(CarerixNodeType type, String value);




}
