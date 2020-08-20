package com.example.examplemod.events;

import com.example.examplemod.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosApi;

public class HardnessEvent {

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (CuriosApi.getCuriosHelper().findEquippedCurio(RegistryHandler.hardnessRing.get(), player).isPresent()) {
                if (!player.isPotionActive(Effects.RESISTANCE)) {
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, Integer.MAX_VALUE, 0, false, false));
                }
            } else {
                player.removePotionEffect(Effects.RESISTANCE);
            }
        }
    }
}
