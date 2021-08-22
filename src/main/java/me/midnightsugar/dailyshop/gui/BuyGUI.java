package me.midnightsugar.dailyshop.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BuyGUI implements MenuHolder {

    public void onClick(Player player, int slot, ItemStack clickedItem) {

    }

    public Inventory getInventory() {
        String shopTitle = "title";
        int shopSize = 54;

        Inventory inv = Bukkit.createInventory(this, shopSize, shopTitle);
        return inv;
    }
}
