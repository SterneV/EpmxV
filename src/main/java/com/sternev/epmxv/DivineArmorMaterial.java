package com.sternev.epmxv;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

import static net.minecraft.registry.tag.ItemTags.REPAIRS_GOLD_ARMOR;

public class DivineArmorMaterial {

    public static final int BASE_DURABILITY = 7;
    public static final RegistryKey<EquipmentAsset> DIVINE_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(EpmxV.MOD_ID, "divine"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 4,
                    EquipmentType.CHESTPLATE, 10,
                    EquipmentType.LEGGINGS, 8,
                    EquipmentType.BOOTS, 4
            ),
            25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            3.0F,
            0.1F,
            REPAIRS_GOLD_ARMOR,
            DIVINE_ARMOR_MATERIAL_KEY
    );
}
