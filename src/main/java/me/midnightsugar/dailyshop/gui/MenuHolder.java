package me.midnightsugar.dailyshop.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface MenuHolder extends InventoryHolder {
    void onClick(Player player, int slot, ItemStack clickedItem);
}
