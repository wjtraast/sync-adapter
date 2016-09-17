package nl.onlyonce.adapter.service.target;

import com.carerix.api.CREmployee;
import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.service.api.CarerixApiService;
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
            apiService.addEmployee(employee);
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

//            ToGenderNode genderNode = new ToGenderNode();
//            CRDataNode crDataNode = new CRDataNode();
//            crDataNode.setId("2003");
//            genderNode.setCRDataNode(crDataNode);
//            employee.setToGenderNode(genderNode);

//            CRUser crUser = new CRUser();
//            crUser.setId(AppConfig.CARERIX_USER_ID);
//
//            Owner owner = new Owner();
//            owner.setCRUser(crUser);
//
//            employee.setOwner(owner);
        return employee;
    }


}
