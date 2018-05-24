package AT.MSev.ReturnStone;

import AT.MSev.Mango.CustomItemBase;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandSetReturnStoneLocation implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equals("setZS")) {
            Main.config.getConfig().set("ReturnStone.Location", commandSender.getServer().getPlayer(commandSender.getName()).getLocation());
            commandSender.getServer().getPlayer(commandSender.getName()).sendMessage(ChatColor.DARK_GREEN + "Location set.");
            Main.config.saveConfig();
            return true;
        }
        if(command.getName().equals("Zs")) {
            CustomItemBase.Get("ReturnStone").Give(commandSender.getServer().getPlayer(commandSender.getName()));
            commandSender.getServer().getPlayer(commandSender.getName()).sendMessage(ChatColor.DARK_GREEN + "Summoned a Zenimays stone.");
        }
        return false;
    }
}
