package com.sternev.epmxv;

import com.sternev.epmxv.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(EpmxV.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
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
    // to now add a new item simply follow the code below and change "forbidden fruit" to new item name using item.settings() to determine what type of item it is "food, tool etc see docs https://docs.fabricmc.net/develop/items/first-item)
    public static final Item FORBIDDEN_FRUIT = register("forbidden_fruit"
            , Item::new, new Item.Settings().food(POISON_FOOD_COMPONENT, POISON_FOOD_CONSUMABLE_COMPONENT));

    public static final Item DIVINE_SWORD = register("divine_sword"
            ,settings -> new SwordItem(ToolMaterial.GOLD, 10f, -2.3f, settings), new Item.Settings());

    public static final Item DIVINE_CHESTPLATE = register("divine_chestplate"
            ,settings -> new ArmorItem(DivineArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE, settings),
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(DivineArmorMaterial.BASE_DURABILITY)));

    public static final Item DIVINE_HELMET = register("divine_helmet"
            ,settings -> new ArmorItem(DivineArmorMaterial.INSTANCE, EquipmentType.HELMET, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(DivineArmorMaterial.BASE_DURABILITY)));

    public static final Item DIVINE_LEGGINGS = register("divine_leggings"
            ,settings -> new ArmorItem(DivineArmorMaterial.INSTANCE, EquipmentType.LEGGINGS, settings),
            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(DivineArmorMaterial.BASE_DURABILITY)));

    public static final Item DIVINE_BOOTS = register("divine_boots"
            ,settings -> new ArmorItem(DivineArmorMaterial.INSTANCE, EquipmentType.BOOTS, settings),
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(DivineArmorMaterial.BASE_DURABILITY)));




    // makes the static variables get properly set up when loading the game
    public static void initialize() {
        //register group on initialize
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.FORBIDDEN_FRUIT);
            itemGroup.add(ModBlocks.SHRINE.asItem());
            itemGroup.add(ModItems.DIVINE_SWORD);
            itemGroup.add(ModItems.DIVINE_HELMET);
            itemGroup.add(ModItems.DIVINE_CHESTPLATE);
            itemGroup.add(ModItems.DIVINE_LEGGINGS);
            itemGroup.add(ModItems.DIVINE_BOOTS);
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

