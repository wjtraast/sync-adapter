package nl.onlyonce.adapter.service.target;

import com.carerix.api.*;
import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.carerix.CarerixNodeType;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.model.message.ResumeWrapper;
import nl.onlyonce.adapter.service.SyncMessageStoreService;
import nl.onlyonce.adapter.service.api.CarerixApiService;
import nl.onlyonce.adapter.service.api.CarerixModelHelper;
import nl.onlyonce.adapter.util.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;


/**
 * @author: Gerben
 */
@Service
@Log
public class CarerixServiceImpl implements CarerixService {

    @Autowired
    CarerixApiService apiService;

    @Autowired
    SyncMessageStoreService syncMessageStoreService;

    @Override
    public void processMessage(CarerixRequestMessage message) {
        log.info("CarerixServiceImpl : processMessage CarerixRequestMessage");
        try {
            Document result;
            String employeeId = null;
            employeeId = apiService.findEmployee(message.getCardId());
            CREmployee employee = createEmployee(message);
            if (employeeId == null) {
                result = apiService.addEmployee(employee);
            } else {
                apiService.updateEmployee(employeeId, employee);
                result = apiService.getEmployee(employeeId);
            }
            apiService.updateUser(getUserId(result), createUser(message));
            syncMessageStoreService.markAsProcessed(message.getId());
        } catch (Exception e) {
            syncMessageStoreService.markAsFailed(message.getId(), e.getMessage());
        }
    }

    private String getUserId(Document result) {
        return result.getElementsByTagName("toUser").item(0).getChildNodes().item(0).getAttributes().getNamedItem("id").getNodeValue();
    }

    private CRUser createUser(CarerixRequestMessage message) {
        CRUser user = new CRUser();
        user.setJobTitle(message.getJobTitle());
        return user;

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


        String salaryPeriodId = apiService.findIdForValue(CarerixNodeType.Salarisperiode, "per jaar");

        ToCurrentSalaryPeriodNode toCurrentSalaryPeriodNode = new ToCurrentSalaryPeriodNode();
        CRDataNode periodDataNode = new CRDataNode();
        periodDataNode.setId(salaryPeriodId);
        toCurrentSalaryPeriodNode.setCRDataNode(periodDataNode);
        employee.setToCurrentSalaryPeriodNode(toCurrentSalaryPeriodNode);

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
