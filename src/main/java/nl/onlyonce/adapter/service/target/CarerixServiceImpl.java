package nl.onlyonce.adapter.service.target;

import com.carerix.api.CRDataNode;
import com.carerix.api.CREmployee;
import com.carerix.api.ToGenderNode;
import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.service.api.CarerixApiService;
import nl.onlyonce.adapter.service.api.CarerixModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: Gerben
 */
@Service
@Log
public class CarerixServiceImpl implements CarerixService {

    @Autowired
    CarerixApiService apiService;

    @Override
    public void processMessage(CarerixRequestMessage message) {
        log.info("CarerixServiceImpl : processMessage CarerixRequestMessage");

        String employeeId = apiService.findEmployee(message.getCardId());
        CREmployee employee = createEmployee(message);
        if (employeeId == null) {
            CREmployee savedEmployee = apiService.addEmployee(employee);
        } else {
            apiService.updateEmployee(employeeId, employee);
        }

    }

    private CREmployee createEmployee(final CarerixRequestMessage message) {
        CREmployee employee = new CREmployee();
        employee.setFirstName(message.getFirstname());
        employee.setLastName(message.getLastname());
        employee.setInitials(message.getInitials());
        employee.setEmailAddress(message.getEmail1());
        employee.setBirthDate(message.getDateOfBirth());
        employee.setCity(message.getCity());
        employee.setHouseNumber(message.getHouseNumber());
        employee.setInitials(message.getInitials());
        employee.setMobileNumber(message.getMobile1());
        employee.setPhoneNumber(message.getLandline1());
        employee.setPostalCode(message.getPostalCode());
        employee.setStreet(message.getStreetname1());
        employee.setNotes("<!-- do not edit this line !! ref=" + message.getCardId() + " -->");

        ToGenderNode toGenderNode = new ToGenderNode();
        CRDataNode dataNode = new CRDataNode();
        dataNode.setId(CarerixModelHelper.GENDER_DATA_NODE_ID);
        dataNode.setValue(message.getGender());
        toGenderNode.setCRDataNode(dataNode);
        employee.setToGenderNode(toGenderNode);

        return employee;
    }

    private void updateGender(String gender) {
       // apiService.updateGender(gender);

    }


}
