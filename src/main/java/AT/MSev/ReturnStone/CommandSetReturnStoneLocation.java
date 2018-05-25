package AT.MSev.ReturnStone;

import AT.MSev.Mango.CustomItemBase;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetReturnStoneLocation implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equals("setZS")) {
            Main.config.getConfig().set("ReturnStone.Location", commandSender.getServer().getPlayer(commandSender.getName()).getLocation());
            ((Player)commandSender).sendMessage(ChatColor.DARK_GREEN + "Location set.");
            Main.config.saveConfig();
            return true;
        }
        if(command.getName().equals("Zs")) {
            CustomItemBase.Get("ReturnStone").Give(((Player)commandSender));
            ((Player)commandSender).sendMessage(ChatColor.DARK_GREEN + "Summoned a Zenimays stone.");
        }
        return false;
    }
}
