package com.sternev.epmxv;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

import java.util.HashMap;
import java.util.UUID;

public class SwordBlocking {
    private static final HashMap<UUID, Long> lastBlockTimes = new HashMap<>();
    private static final HashMap<UUID, Boolean> isBlocking = new HashMap<>();
    private static final long BLOCK_COOLDOWN = 500; // 0.5 seconds

    public static void initialize() {
        // Right-click to block
        UseItemCallback.EVENT.register((player, world, hand) -> {
            Item heldItem = player.getStackInHand(hand).getItem();
            if (isSword(heldItem)) {
                UUID playerId = player.getUuid();
                long currentTime = System.currentTimeMillis();
                long lastBlockTime = lastBlockTimes.getOrDefault(playerId, 0L);

                // Check cooldown
                if (currentTime - lastBlockTime >= BLOCK_COOLDOWN) {
                    isBlocking.put(playerId, true);
                    lastBlockTimes.put(playerId, currentTime);
                    player.sendMessage(Text.of("You are now blocking!"), true);
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
        // Apply damage reduction when blocking


        // Reset blocking after a cooldown (example cleanup logic)
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            isBlocking.entrySet().removeIf(entry -> {
                UUID playerId = entry.getKey();
                long currentTime = System.currentTimeMillis();
                return currentTime - lastBlockTimes.get(playerId) > BLOCK_COOLDOWN;
            });
        });
    }
    // check if item in hand is sword
    private static boolean isSword(Item item) {
        return item == Items.WOODEN_SWORD || item == Items.STONE_SWORD ||
                item == Items.IRON_SWORD || item == Items.DIAMOND_SWORD ||
                item == Items.NETHERITE_SWORD;
    }

}

