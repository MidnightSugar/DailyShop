package me.midnightsugar.dailyshop.gui;

import me.midnightsugar.dailyshop.Shop;
import me.midnightsugar.dailyshop.ShopItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EditGUI implements MenuHolder, Listener {
    private Shop shop;

    public EditGUI(Shop shop){
        this.shop = shop;
    }

    public EditGUI() {

    }

    @Override
    public void onClick(Player player, int slot, ItemStack clickedItem) {

    }

    @Override
    public Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(this, shop.getShopSize());
        if (shop.getShopItems().isEmpty()) return inv;
        int slot = 0;
        for (ShopItem item : shop.getShopItems()) {
            if (slot == shop.getShopSize() - 1) {
                return inv;
            }
            inv.addItem(item.getGuiItem());
            slot++;
        }
        return inv;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getInventory().getHolder() instanceof EditGUI){
            event.getPlayer().sendMessage("Test");
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getSlot())
    }
}
