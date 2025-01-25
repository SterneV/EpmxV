package com.sternev.epmxv;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;


import java.util.HashMap;
import java.util.UUID;

public class SwordBlocking {
    private static final HashMap<UUID, Boolean> isBlocking = new HashMap<>();
    private static final double DAMAGE_REDUCTION = 0.5; // 50% reduction

    public static void initialize() {
        // Right-click to block
        UseItemCallback.EVENT.register((player, world, hand) -> {
            Item heldItem = player.getStackInHand(hand).getItem();
            if (isSword(heldItem)) {
                UUID playerId = player.getUuid();

                // Starts blocking
                isBlocking.put(playerId, true);
                System.out.println("Player " + player.getName().getString() + " is now blocking!");
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;

        });

    }
    private static boolean isSword(Item item) {
        return item == Items.WOODEN_SWORD || item == Items.STONE_SWORD ||
                item == Items.IRON_SWORD || item == Items.DIAMOND_SWORD ||
                item == Items.GOLDEN_SWORD || item == Items.NETHERITE_SWORD;
    }

}