package AT.MSev.ReturnStone;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static NamespacedKey key;
    public static Main config;
    @Override
    public void onEnable() {
        key = new NamespacedKey(this, this.getDescription().getName());
        config = this;

        new CustomItemReturnStone();
        this.getCommand("setZS").setExecutor(new CommandSetReturnStoneLocation());
        this.getCommand("Zs").setExecutor(new CommandSetReturnStoneLocation());

        getServer().getPluginManager().registerEvents(new Handler(), this);
    }
    @Override
    public void onDisable() {

    }
}
