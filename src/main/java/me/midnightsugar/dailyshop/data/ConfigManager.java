package me.midnightsugar.dailyshop.data;

import me.midnightsugar.dailyshop.DailyShop;
import me.midnightsugar.dailyshop.Shop;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    public static File shopFile;
    public static YamlConfiguration shopConfig;

    public static void initialize() {
        DailyShop.plugin.saveDefaultConfig();
        File file = new File(DailyShop.plugin.getDataFolder(), "shops.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        shopFile = file;
        shopConfig = YamlConfiguration.loadConfiguration(file);
    }

    public static Shop getShopData(String shop) {
        return (Shop) shopConfig.get("shops." + shop);
    }

    public static void saveShopData() {
        try {
            shopConfig.save(shopFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

