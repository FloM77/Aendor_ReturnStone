package AT.MSev.ReturnStone;

import AT.MSev.Mango.CustomItemInteractable;
import org.bukkit.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class CustomItemReturnStone extends CustomItemInteractable {
    public CustomItemReturnStone()
    {
        super("ReturnStone", Material.EMERALD);
        Rename("Zenimays stone");
        Cooldown = 5000;
        SetLore(new ArrayList<String>() {{add("A stone given by the priests of Zenimay."); add("Use it get to the temple.");}});
    }

    @Override
    public void RightClickEvent(PlayerInteractEvent e) {
        super.RightClickEvent(e);
        if(RightClickCanceled) return;

        e.getPlayer().getWorld().playEffect(e.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 0);

        Location toTeleport = e.getPlayer().getWorld().getSpawnLocation();
        if(Main.config.getConfig().contains("ReturnStone.Location")) toTeleport = (Location) Main.config.getConfig().get("ReturnStone.Location");
        e.getPlayer().teleport(toTeleport);

        e.getPlayer().getWorld().playEffect(e.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 0);
        e.getPlayer().sendMessage(ChatColor.DARK_GREEN + "Zenimays stone teleported you!");
    }


    @Override
    public void DropEvent(PlayerDropItemEvent e) {
        e.getItemDrop().remove();
        e.getPlayer().sendMessage(ChatColor.DARK_GREEN + "Zenimays stone dissapeared.");
    }
}
