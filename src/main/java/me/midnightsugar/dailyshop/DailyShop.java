package me.midnightsugar.dailyshop;

import me.midnightsugar.dailyshop.commands.CommandManager;
import me.midnightsugar.dailyshop.data.ConfigManager;
import me.midnightsugar.dailyshop.gui.EditGUI;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public class DailyShop extends JavaPlugin {
    public static DailyShop plugin;

    @Override
    public void onLoad() {
        ConfigurationSerialization.registerClass(Shop.class);
    }

    @Override
    public void onEnable() {
        plugin = this;

        ConfigManager.initialize();

        this.getCommand("dailyshop").setExecutor(new CommandManager());
        getServer().getPluginManager().registerEvents(new EditGUI(), this);
    }

    @Override
    public void onDisable() {
        plugin = this;

        ConfigManager.saveShopData();
    }

}
