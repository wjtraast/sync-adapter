package nl.onlyonce.adapter.service.api;

/**
 * @author: Gerben
 */
public class ZohoApiException extends Exception {

    private String code;
    private String message;

    public ZohoApiException(String code, String message) {
        super();
        this.code = code;
        this.message = message;

    }

    @Override
    public String getMessage() {
        return code + "|" + message;
    }
}
