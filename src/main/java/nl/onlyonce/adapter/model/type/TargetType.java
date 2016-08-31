package nl.onlyonce.adapter.model.type;

/**
 * @author: Gerben
 */
public enum TargetType {

    SALESFORCE, SOHO, CARERIX;

    public static TargetType asTargetType(final String str) {
        for (TargetType me : TargetType.values()) {
            if (me.name().equalsIgnoreCase(str))
                return me;
        }
        return null;
    }
}
