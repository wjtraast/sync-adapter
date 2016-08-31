package nl.onlyonce.adapter.model;

/**
 * @author: Gerben
 */
public enum Command {

    SYNC;


    public static Command asCommand(String str) {
        for (Command me : Command.values()) {
            if (me.name().equalsIgnoreCase(str))
                return me;
        }
        return null;
    }
}
