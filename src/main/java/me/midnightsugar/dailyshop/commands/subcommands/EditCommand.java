package me.midnightsugar.dailyshop.commands.subcommands;

import me.midnightsugar.dailyshop.commands.SubCommand;
import me.midnightsugar.dailyshop.data.ConfigManager;
import me.midnightsugar.dailyshop.gui.EditGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EditCommand extends SubCommand {
    @Override
    public String getName() {
        return "edit";
    }

    @Override
    public String getDescription() {
        return "Edit a shop.";
    }

    @Override
    public String getSyntax() {
        return "/dailyshop edit <name>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.openInventory(new EditGUI(ConfigManager.getShopData(args[1])).getInventory());
        }
    }
}
