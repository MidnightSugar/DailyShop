package me.midnightsugar.dailyshop;

import me.midnightsugar.dailyshop.utils.Common;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VanillaItem extends ShopItem {
    private int weight;
    private double minPrice;
    private double maxPrice;
    private int minAmount;
    private int maxAmount;
    private ItemStack item;

    public VanillaItem(Map<String, Object> map) {
        try {
            if (map.containsKey("Weight")){
                weight = (int) map.get("Weight");
            }
            item = (ItemStack) map.get("ItemStack");
            if (item == null) {
                throw new RuntimeException("ItemStack cannot be null");
            }
            if (map.containsKey("Min_Price")) {
                minPrice = (Double) map.get("Min_Price");
            }
            if (map.containsKey("Max_Price")) {
                maxPrice = (Double) map.get("Max_Price");
            }
            if (map.containsKey("Min_Amount")) {
                minAmount = (int) map.get("Min_Amount");
            }
            if (map.containsKey("Max_Amount")) {
                maxAmount = (int) map.get("Max_Amount");
            }
        } catch (Exception ex) {
            Bukkit.getLogger().severe("Failed to load shop data!");
        }
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new TreeMap<>();
        map.put("Weight", weight);
        map.put("ItemStack", item);
        map.put("Min_Price", minPrice);
        map.put("Max_Price", maxPrice);
        map.put("Min_Amount", minAmount);
        map.put("Max_Amount", maxAmount);
        return map;
    }

    @Override
    public ItemStack getGuiItem() {
        double price = Common.getRandomDouble(minPrice, maxPrice);
        if (price > 10) {
            price = Math.round(price);
        }
        ItemStack guiItem = item;
        ItemMeta meta = guiItem.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "Price: " + price);
        meta.setLore(lore);
        guiItem.setItemMeta(meta);
        guiItem.setAmount(Common.getRandomInt(minAmount, maxAmount));

        return guiItem;
    }
}
