package nl.onlyonce.adapter.service.api;

/**
 * @author: Gerben
 */
public class ZoHoApiConfiguration {

    public static final String SCOPE = "crmapi";
    public static final String NEWFORMAT = "1";
 //   public static final String ENDPOINT = "https://crm.zoho.com/crm/private/xml";


    public class Endpoints {
        public class Contact {
            public static final String INSERT_RECORDS  = "/Contacts/insertRecords";
            public static final String UPDATE_RECORDS  = "/Contacts/updateRecords";
            public static final String SEARCH_RECORDS  = "/Contacts/searchRecords";
            public static final String GET_SEARCH_RECORSDS_BY_PDC  = "/Contacts/getSearchRecordsByPDC";

            public static final String UPLOAD_FILE = "/Contacts/uploadFile";
            public static final String DELETE_FILE = "/Contacts/deleteFile";

        }

        public class Account {
            public static final String INSERT_RECORDS  = "/Accounts/insertRecords";

        }

        public class Attachment {
            public static final String GET_RELATED_RECORDS = "/Attachments/getRelatedRecords";
        }
    }
}
