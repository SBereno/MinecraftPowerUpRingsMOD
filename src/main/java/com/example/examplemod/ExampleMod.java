package com.example.examplemod;

import com.example.examplemod.events.*;
import com.example.examplemod.util.GroupGenerator;
import com.example.examplemod.util.RegistryHandler;
import com.example.examplemod.util.SupportMods;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("poweruprings")
public class ExampleMod {

    public static final String MOD_ID = "poweruprings";
    public static final Logger logger = LogManager.getLogger(MOD_ID);

    public ExampleMod() {
        RegistryHandler.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        registerEvents();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        if (SupportMods.CURIOS.isLoaded()) {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("ring").size(2).build());
        }
    }

    private void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new HardnessEvent());
        MinecraftForge.EVENT_BUS.register(new HasteEvent());
        MinecraftForge.EVENT_BUS.register(new RespirationEvent());
        MinecraftForge.EVENT_BUS.register(new SatiationEvent());
        MinecraftForge.EVENT_BUS.register(new StrengthEvent());
        MinecraftForge.EVENT_BUS.register(new SwiftnessEvent());
        MinecraftForge.EVENT_BUS.register(new VitalityEvent());
    }
}
