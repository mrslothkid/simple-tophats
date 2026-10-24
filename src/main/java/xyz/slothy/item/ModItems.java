package xyz.slothy.item;

import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.Equippable;
import xyz.slothy.SimpleTophat;

import java.util.function.Function;

public final class ModItems {
    public static final Item TOPHAT = register(ModItemIds.TOPHAT, new Item.Properties()
            .component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.HEAD).setAllowedEntities(
                    EntityTypes.PLAYER, EntityTypes.FOX, EntityTypes.ZOMBIE, EntityTypes.SKELETON
            ).build())
            .stacksTo(1));

    public static final CreativeModeTab CREATIVE_TAB = FabricCreativeModeTab.builder()
            .icon(TOPHAT::getDefaultInstance)
            .title(Component.translatable("creativeTab.simple_tophat"))
            .displayItems((parameters, output) -> {
                output.accept(TOPHAT);
            })
            .build();

    private static Item register(String path, Item.Properties properties) {
        ResourceKey<Item> resourceKey = ResourceKey.create(Registries.ITEM, SimpleTophat.id(path));
        return register(resourceKey, properties);
    }

    private static Item register(ResourceKey<Item> resourceKey, Item.Properties properties) {
        return register(resourceKey, p -> new SimplePolymerItem(p, Items.TRIAL_KEY, true), properties);
    }

    private static Item register(ResourceKey<Item> resourceKey, Function<Item.Properties, Item> factory, Item.Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM, resourceKey, factory.apply(properties.setId(resourceKey)));
    }

    public static void load() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, SimpleTophat.id("creative_tab"), CREATIVE_TAB);
    }
}
