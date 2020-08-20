package com.example.examplemod.events;

import com.example.examplemod.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.theillusivec4.curios.api.CuriosApi;

public class VitalityEvent {


    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (CuriosApi.getCuriosHelper().findEquippedCurio(RegistryHandler.vitalityRing.get(), player).isPresent()) {
                if (!player.isPotionActive(Effects.REGENERATION)) {
                    player.addPotionEffect(new EffectInstance(Effects.REGENERATION, Integer.MAX_VALUE, 0, false, false));
                }
            } else {
                player.removePotionEffect(Effects.REGENERATION);
            }
        }
    }
}

