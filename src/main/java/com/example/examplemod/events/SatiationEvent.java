package com.example.examplemod.events;

import com.example.examplemod.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosApi;

public class SatiationEvent {

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (CuriosApi.getCuriosHelper().findEquippedCurio(RegistryHandler.satiationRing.get(), player).isPresent()) {
                if (player.getFoodStats().getFoodLevel() < 20) {
                    player.getFoodStats().setFoodLevel(20);
                }
            }
        }
    }
}

