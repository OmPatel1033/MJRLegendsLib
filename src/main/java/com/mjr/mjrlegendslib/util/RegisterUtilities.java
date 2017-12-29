package com.mjr.mjrlegendslib.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterUtilities {
	private static int id = 0;

	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getRegistryName());
	}

	public static void registerBlock(Block block, String name) {
		GameRegistry.registerBlock(block, name);
	}

	public static void registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name) {
		GameRegistry.registerBlock(block, itemclass, name);
	}

	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getRegistryName());
	}

	public static void registerItem(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}

	public static void registerNonMobEntity(Object mod, Class<? extends Entity> var0, String var1, int trackingDistance, int updateFreq, boolean sendVel) {
		EntityRegistry.registerModEntity(var0, var1, id++, mod, trackingDistance, updateFreq, sendVel);
	}

	public static void registerMobEntity(Object mod, Class<? extends Entity> entityClass, String name, int back, int fore) {
		registerNonMobEntity(mod, entityClass, name, 80, 3, true);
		EntityRegistry.registerEgg(entityClass, back, fore);
	}

	public static void setHarvestLevel(Block block, String toolClass, int level, int meta) {
		block.setHarvestLevel(toolClass, level, block.getStateFromMeta(meta));
	}
}
