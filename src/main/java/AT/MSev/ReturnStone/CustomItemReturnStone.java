package AT.MSev.ReturnStone;

import AT.MSev.Mango_Core.Items.ItemInteractable;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class CustomItemReturnStone extends ItemInteractable {
    public CustomItemReturnStone()
    {
        super("ReturnStone", Material.EMERALD);
        Rename("Zenimays stone");
        Cooldown = 5000;
        SetLore(new ArrayList<String>() {{add("A stone given by the priests of Zenimay."); add("Use it get to the temple.");}});
    }

    @Override
    public void OnRightClick(PlayerInteractEvent e) {
        super.OnRightClick(e);
        if(Cancel) return;

        World world = e.getPlayer().getWorld();
        Player player = e.getPlayer();

        world.playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 0);

        Location toTeleport = world.getSpawnLocation();
        if(Main.config.getConfig().contains("ReturnStone.Location")) toTeleport = (Location) Main.config.getConfig().get("ReturnStone.Location");
        player.teleport(toTeleport);

        world.playEffect(e.getPlayer().getLocation(), Effect.ENDER_SIGNAL, 0);
        player.sendMessage(ChatColor.DARK_GREEN + "Zenimays stone teleported you!");
    }


    @Override
    public void OnDrop(PlayerDropItemEvent e) {
        e.getItemDrop().remove();
        e.getPlayer().sendMessage(ChatColor.DARK_GREEN + "Zenimays stone dissapeared.");
    }
}
