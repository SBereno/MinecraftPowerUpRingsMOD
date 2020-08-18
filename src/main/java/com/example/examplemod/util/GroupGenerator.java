package com.example.examplemod.util;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GroupGenerator extends ItemGroup
{
    public GroupGenerator()
    {
        super("rings");
    }

    @Override
    public ItemStack createIcon() {
        return null;
    }
}
