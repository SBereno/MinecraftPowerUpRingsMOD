package com.example.examplemod.util;

import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.ModList;

// Credit to Corail31, taken from Travel Bag mod

public enum SupportMods implements IStringSerializable
{
    CURIOS("curios");

    private final String modid;
    private final boolean loaded;

    SupportMods(String modid) {
        this.modid = modid;
        this.loaded = ModList.get() != null && ModList.get().getModContainerById(modid).isPresent();
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public String getName() {
        return this.modid;
    }

    @Override
    public String func_176610_l() {
        return null;
    }
}