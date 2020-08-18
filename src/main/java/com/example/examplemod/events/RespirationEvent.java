package com.example.examplemod.events;

import com.example.examplemod.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosApi;

public class RespirationEvent {

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (CuriosApi.getCuriosHelper().findEquippedCurio(RegistryHandler.respirationRing.get(), player).isPresent()) {
                if (!player.isPotionActive(Effects.WATER_BREATHING)) {
                    player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, Integer.MAX_VALUE, 0, false, false));
                }
            } else {
                player.removePotionEffect(Effects.WATER_BREATHING);
            }
        }
    }
}
