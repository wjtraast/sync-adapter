package nl.onlyonce.adapter.service.api;

/**
 * @author: Gerben
 */
public class ZoHoApiConfiguration {

    public static final String SCOPE = "crmapi";
    public static final String NEWFORMAT = "1";
    public static final String ENDPOINT = "https://crm.zoho.com/crm/private/xml";


    public class Endpoints {
        public class Contact {
            public static final String INSERT_RECORDS  = "/Contacts/insertRecords";
        }

        public class Account {
            public static final String INSERT_RECORDS  = "/Accounts/insertRecords";

        }
    }
}
