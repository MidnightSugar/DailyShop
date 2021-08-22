package me.midnightsugar.dailyshop;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

public abstract class ShopItem implements ConfigurationSerializable {
    int weight = 1;

    public abstract ItemStack getGuiItem();
}
