package com.sternev.epmxv;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, RegistryKey<Item> registryKey) {
        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        // Return the registered item!
        return registeredItem;
    }

    // Creates a unique key and identifier for the item, defines its properties,
    // and registers it in the Minecraft item registry.
    public static final RegistryKey<Item> SUSPICIOUS_SUBSTANCE_KEY = RegistryKey.of(RegistryKeys.ITEM,
            Identifier.of(EpmxV.MOD_ID, "suspicious_substance"));
    public static final Item SUSPICIOUS_SUBSTANCE = register(
            new Item(new Item.Settings().registryKey(SUSPICIOUS_SUBSTANCE_KEY)),
            SUSPICIOUS_SUBSTANCE_KEY
    );

    // makes the static variables get properly set up when loading the game
    public static void initialize() {
        //adds our item to a creative tab in this case(INGREDIENTS)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE));
    }
}

