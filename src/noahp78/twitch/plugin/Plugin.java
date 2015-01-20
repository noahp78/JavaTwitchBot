package noahp78.twitch.plugin;

public interface Plugin {
    boolean onEnable();
    boolean onDisable();
    String getName();
    String getVersion();
}
