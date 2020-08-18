package com.example.examplemod.util;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.items.BaseRing;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> swiftnessRing = ITEMS.register("swiftnessring", BaseRing::new);
    public static final RegistryObject<Item> respirationRing = ITEMS.register("respirationring", BaseRing::new);

}
