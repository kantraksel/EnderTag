package pl.kantraksel.endertag;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

@EventBusSubscriber(modid = EnderTag.MODID)
public class EventSubscriber {
	@SubscribeEvent
	public static void onTeleport(EnderTeleportEvent event) {
		if (EnderConfig.isEnabled) {
			Entity entity = event.getEntity();
			if (entity instanceof EntityEnderman && entity.hasCustomName()) 
				event.setCanceled(true);
		}
	}
}
