package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;

import java.util.Date;

/**
 * @author: Gerben
 */
public class Fixtures {

    public static final Date SYNC_DATE = new Date();


    public static ZohoRequestMessage getFullZohoRequstMessage() {



        ZohoRequestMessage message = new ZohoRequestMessage();
        message.setCardname("My Card");
        message.setFirstname("Jan");
        message.setLastname("Jansen");
        message.setInitials("JJ");
        message.setSalutation("Male");
        message.setAcademicTitle("Ing.");
        message.setType("pds");
        message.setMobile1("061111111");
        message.setMobile2("061111111");
        message.setMobile3("061111111");
        message.setLandline1("0201111111");
        message.setLandline2("0201111111");
        message.setLandline3("0201111111");
        message.setEmail1("test@test.nl");
        message.setEmail2("test@test.nl");
        message.setDateOfBirth("20/02/1972");
        message.setStreetname("Kerkstraat");
        message.setPostalcode("1101AA");
        message.setRegion("Noord Holland");
        message.setCity("Amsterdam");
        message.setCountry("Nederland");
        message.setJobPosition("Fixed contract");
        message.setFlexAvailabilityFrom("01/01/2016");
        message.setFlexAvailabilityTo("31/01/2016");
        message.setHourlyRate("100");
        message.setMinHourRate("100");
        message.setSkills("Software|Engineering");

        message.setSkypeId("gerbenvis");
        message.setLinkedin("http://www.linkedin/in/gerbenvis");
        message.setWebsite("http://www.onlyonce.nl");
        return message;



    }
}
