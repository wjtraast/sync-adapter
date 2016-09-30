package nl.onlyonce.adapter.service.target;

import com.carerix.api.*;
import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.carerix.CarerixNodeType;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.model.message.ResumeWrapper;
import nl.onlyonce.adapter.service.api.CarerixApiService;
import nl.onlyonce.adapter.service.api.CarerixModelHelper;
import nl.onlyonce.adapter.util.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


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
        employee.setBirthDate(message.getDateOfBirth() + " 00:00:00");
        employee.setCity(message.getCity());
        employee.setHouseNumber(message.getHouseNumber());
        employee.setInitials(message.getInitials());
        employee.setMobileNumber(message.getMobile1());
        employee.setPhoneNumber(message.getLandline1());
        employee.setPostalCode(message.getPostalCode());
        employee.setStreet(message.getStreetname1());
        employee.setNotes("<!-- do not edit this line !! ref=" + message.getCardId() + " -->");
        employee.setCurrentSalary(message.getCurrentSalary());


        String genderId = apiService.findIdForValue(CarerixNodeType.Geslacht, CarerixModelHelper.toGender(message.getGender()));

        ToGenderNode toGenderNode = new ToGenderNode();
        CRDataNode dataNode = new CRDataNode();
        dataNode.setId(genderId);
        toGenderNode.setCRDataNode(dataNode);
        employee.setToGenderNode(toGenderNode);

        String dateFormat = "yyyy-MM-dd";
        if (DateValidator.isValid(message.getAvailableFromDate(), dateFormat)) {
            employee.setAvailableFromDate(message.getAvailableFromDate() + " 00:00:00");
            employee.setAvailableDate(message.getAvailableFromDate() + " 00:00:00");
        } else {
            log.info(message.getAvailableFromDate() + " does not have this format : " + dateFormat);
        }

//        String availabilityId = apiService.findIdForValue(CarerixNodeType.Opzegtermijn, message.getAvailability());
//
//        ToAvailableWithinNode node = new ToAvailableWithinNode();
//        CRDataNode availabilityNode = new CRDataNode();
//        availabilityNode.setId(availabilityId);
//        node.setCRDataNode(availabilityNode);
//        employee.setToAvailableWithinNode(node);


        if (!CollectionUtils.isEmpty(message.getResumes())) {
            Attachments attachments = new Attachments();
            for (ResumeWrapper resume : message.getResumes()) {

                if (!StringUtils.isEmpty(resume.getFilename()) &&
                        !StringUtils.isEmpty(resume.getFileContent())) {
                    attachments.getCRAttachment().add(createCRAttachment(resume));
                }

            }
            if (!CollectionUtils.isEmpty(attachments.getCRAttachment())) {
                employee.setAttachments(attachments);
            }
        }

        return employee;
    }

    private CRAttachment createCRAttachment(ResumeWrapper resume) {
        CRAttachment crAttachment = new CRAttachment();
        crAttachment.setFilePath(resume.getFilename());
        ToAttachmentData toAttachmentData = new ToAttachmentData();
        CRAttachmentData crAttachmentData = new CRAttachmentData();
        crAttachmentData.setContent(resume.getFileContent());
        toAttachmentData.setCRAttachmentData(crAttachmentData);
        crAttachment.setToAttachmentData(toAttachmentData);
        return crAttachment;
    }

    private void updateGender(String gender) {
       // apiService.updateGender(gender);

    }


}
