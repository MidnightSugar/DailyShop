package me.midnightsugar.dailyshop;

import me.midnightsugar.dailyshop.utils.Common;
import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.*;

public class Shop implements ConfigurationSerializable {
    int shopSize = 27;
    int minItems = 1;
    int maxItems = 10;
    String shopTitle = "New Shop";
    private Inventory inv;
    private LinkedList<ShopItem> shopItems = new LinkedList<>();

    public Shop(Map<String, Object> map) {
        try {
            shopTitle = (String) map.get("Title");
            shopSize = (int) map.get("Size");
            minItems = (int) map.get("Min_Items");
            maxItems = (int) map.get("Max_Items");
            if (map.get("Items") != null) {
                shopItems = new LinkedList<>((List<ShopItem>) map.get("Items"));
            }
        } catch (Exception ex) {
            Bukkit.getLogger().severe("Failed to load shop data!");
        }
    }

    public LinkedList<ShopItem> getShopItems() {
        return shopItems;
    }

    public Shop() {}

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new TreeMap<>();
        map.put("Title", shopTitle);
        map.put("Size", shopSize);
        map.put("Min_Items", minItems);
        map.put("Max_Items", maxItems);
        if (!shopItems.isEmpty()) {
            map.put("Items", shopItems);
        }
        return map;
    }

    public void createShop(InventoryHolder holder) {
        Inventory inv = Bukkit.createInventory(holder, shopSize, shopTitle);
        int numItems = Common.getRandomInt(minItems, maxItems);
        for (int i = 1; i < numItems; i++) {

        }
    }

    public int getShopSize() {
        return shopSize;
    }
}
