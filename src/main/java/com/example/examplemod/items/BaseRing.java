package com.example.examplemod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BaseRing extends Item {

    public BaseRing() {
        super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1));
    }

}
