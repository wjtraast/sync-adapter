package nl.onlyonce.adapter.model;

/**
 * @author: Gerben
 */
public enum AdapterCommand {

    SYNC;


    public static AdapterCommand asAdapterComand(String str) {
        for (AdapterCommand me : AdapterCommand.values()) {
            if (me.name().equalsIgnoreCase(str))
                return me;
        }
        return null;
    }
}
