package me.midnightsugar.dailyshop.commands.subcommands;

import me.midnightsugar.dailyshop.commands.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand extends SubCommand {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Open help page";
    }

    @Override
    public String getSyntax() {
        return "/dailyshop help";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
    }
}
