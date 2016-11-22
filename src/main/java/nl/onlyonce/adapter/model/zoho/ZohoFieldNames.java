package nl.onlyonce.adapter.model.zoho;

/**
 * @author: Gerben
 */
public class ZohoFieldNames {

    public static class Account {
        public static final String FIRSTNAME = "First Name";
        public static final String LASTNAME = "Last Name";
        public static final String DATE_OF_BIRTH = "Date of Birth";

        public static final String BILLING_STREET = "Billing Street";
        public static final String BILLING_CODE = "BIlling Code";
        public static final String BILLING_STATE = "Billing State";
        public static final String BILLING_COUNTRY = "Billing Country";
    }

    /*
    https://www.zoho.com/crm/help/api/modules-fields.html#Contacts
     */

    public class Contact {

        public static final String CONTACTID = "CONTACTID";
        public static final String FIRSTNAME = "First Name";
        public static final String LASTNAME = "Last Name";
        public static final String DATE_OF_BIRTH = "Date of Birth";


        public static final String MAILING_STREET = "Mailing Street";
        public static final String MAILING_CITY = "Mailing City";
        public static final String MAILING_COUNTRY = "Mailing Country";
        public static final String MAILING_ZIP = "Mailing Zip";
        public static final String MAILING_REGION ="Mailing Region";


        public static final String TITLE = "Title";
        public static final String SALUTATION = "Salutation";
        public static final String DESCRIPTION = "Description";
        public static final String SALUTATION_NULL_VALUE = "-None-";
        public static final String EMAIL1 = "Email";
        public static final String EMAIL2 = "Secondary Email";
        public static final String PHONE = "Phone";
        public static final String OTHER_PHONE = "Other Phone";
        public static final String HOME_PHONE = "Home Phone";
        public static final String MOBILE = "Mobile";
        public static final String SKYPEID = "Skype ID";

        public static final String TWITTER = "Twitter";

        public class Custom {
            public static final String SYNCED_BY_ONLYONCE = "Synced By Only Once";
            public static final String CONTACTCF1 = "Only Once Card ID";
        }
    }
}
