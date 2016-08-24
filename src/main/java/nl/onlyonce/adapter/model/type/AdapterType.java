package nl.onlyonce.adapter.model.type;

/**
 * @author: Gerben
 */
public enum AdapterType {

    SALESFORCE, SOHO, CARERIX;

    public static AdapterType asAdapterType(String str) {
        for (AdapterType me : AdapterType.values()) {
            if (me.name().equalsIgnoreCase(str))
                return me;
        }
        return null;
    }
}
