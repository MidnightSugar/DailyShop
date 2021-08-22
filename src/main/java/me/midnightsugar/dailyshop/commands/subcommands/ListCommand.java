package me.midnightsugar.dailyshop.commands.subcommands;

import me.midnightsugar.dailyshop.commands.SubCommand;
import me.midnightsugar.dailyshop.data.ConfigManager;
import org.bukkit.command.CommandSender;

public class ListCommand extends SubCommand {
    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "List shops.";
    }

    @Override
    public String getSyntax() {
        return "/dailyshop list";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("Shops: ");
        for (String key : ConfigManager.shopConfig.getConfigurationSection("shops").getKeys(false)) {
            builder.append(key).append(", ");
        }
        builder.setLength(builder.length() - 2);
        sender.sendMessage(builder.toString());
    }
}
