package xyz.slothy.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import xyz.slothy.SimpleTophat;

public class ModItemIds {
    public static final ResourceKey<Item> TOPHAT = create("tophat");

    private static ResourceKey<Item> create(final String name) {
        return ResourceKey.create(Registries.ITEM, SimpleTophat.id(name));
    }
}
