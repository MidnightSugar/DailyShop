package me.midnightsugar.dailyshop.commands.subcommands;

import me.midnightsugar.dailyshop.commands.SubCommand;
import me.midnightsugar.dailyshop.data.ConfigManager;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends SubCommand {
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reload config files.";
    }

    @Override
    public String getSyntax() {
        return "/dailyshop reload";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        ConfigManager.initialize();
        sender.sendMessage("Plugin reloaded.");
    }
}
