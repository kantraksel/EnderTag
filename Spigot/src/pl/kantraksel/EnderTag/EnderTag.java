package pl.kantraksel.EnderTag;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EnderTag extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onTeleport(EntityTeleportEvent event) {
		if (getConfig().getBoolean("enabled")) {
			Entity entity = event.getEntity();
			if (entity.getType().equals(EntityType.ENDERMAN) && entity.getCustomName() != null) {
				event.setCancelled(true);
			}
		}
	}
}
