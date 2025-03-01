package com.sternev.epmxv;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, RegistryKey<Item> registryKey) {
        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        // Return the registered item!
        return registeredItem;
    }


    public static final ConsumableComponent POISON_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // The duration is in ticks, 20 ticks = 1 second
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 6 * 20, 1), 1.0f))
            .build();
    public static final FoodComponent POISON_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();

    // Creates a unique key and identifier for the item, defines its properties,
    // and registers it in the Minecraft item registry.
    public static final RegistryKey<Item>FORBIDDEN_FRUIT_KEY  = RegistryKey.of(RegistryKeys.ITEM,
            Identifier.of(EpmxV.MOD_ID, "forbidden_fruit"));
    public static final Item FORBIDDEN_FRUIT = register(
            new Item(new Item.Settings().food(POISON_FOOD_COMPONENT, POISON_FOOD_CONSUMABLE_COMPONENT).registryKey(FORBIDDEN_FRUIT_KEY)),
            FORBIDDEN_FRUIT_KEY
    );



    // makes the static variables get properly set up when loading the game
    public static void initialize() {
        //register group on initialize
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.FORBIDDEN_FRUIT);
            itemGroup.add(ModBlocks.SHRINE.asItem());
            //..
        });

    }
    //custom group register
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(EpmxV.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.FORBIDDEN_FRUIT))
            .displayName(Text.translatable("itemGroup.epmxv"))
            .build();
}

