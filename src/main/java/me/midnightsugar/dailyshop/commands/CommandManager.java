package me.midnightsugar.dailyshop.commands;

import me.midnightsugar.dailyshop.commands.subcommands.CreateCommand;
import me.midnightsugar.dailyshop.commands.subcommands.EditCommand;
import me.midnightsugar.dailyshop.commands.subcommands.HelpCommand;
import me.midnightsugar.dailyshop.commands.subcommands.ReloadCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    private final ArrayList<SubCommand> subCommands = new ArrayList<>();

    public CommandManager() {
        subCommands.add(new HelpCommand());
        subCommands.add(new ReloadCommand());
        subCommands.add(new CreateCommand());
        subCommands.add(new EditCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args.length > 0) {
            for (SubCommand subCommand : subCommands) {
                if (args[0].equalsIgnoreCase(subCommand.getName())) {
                    subCommand.perform(sender, args);
                }
            }
        }

        return true;
    }
}
