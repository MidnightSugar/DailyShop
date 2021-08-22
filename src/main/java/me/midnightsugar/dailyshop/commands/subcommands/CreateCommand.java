package me.midnightsugar.dailyshop.commands.subcommands;

import me.midnightsugar.dailyshop.Shop;
import me.midnightsugar.dailyshop.commands.SubCommand;
import me.midnightsugar.dailyshop.data.ConfigManager;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class CreateCommand extends SubCommand {
    @Override
    public String getName() {
        return "create";
    }
    @Override
    public String getDescription() {
        return "Create a new shop.";
    }

    @Override
    public String getSyntax() {
        return "/dailyshop create <name> [title] [size]";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("Please enter a name!");
            sender.sendMessage(getSyntax());
            return;
        }

        if (ConfigManager.shopConfig.contains("shops." + args[1])) {
            sender.sendMessage("That shop already exists!");
            return;
        }

        if (args.length == 2) {
            ConfigManager.shopConfig.set("shops." + args[1], new Shop());
            ConfigManager.saveShopData();
        }
    }
}
