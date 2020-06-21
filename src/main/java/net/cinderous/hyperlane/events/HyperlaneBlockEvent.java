package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HyperlaneBlockEvent {

    @SubscribeEvent
    public static void HyperlaneBlockEvent(BlockEvent.EntityPlaceEvent event) {
        if(event.getPlacedBlock() == RegistryHandler.HYPHINITY_ORE.get().getDefaultState()) {
           // event.getEntity().setGlowing(true);
           //

            Hyperlane.LOGGER.info("WE FOUND HYPHINITY ORE BEING PLACED AT" + event.getPos());
          //
        }
    }
}