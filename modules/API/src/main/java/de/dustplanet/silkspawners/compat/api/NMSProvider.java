package de.dustplanet.silkspawners.compat.api;

import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public interface NMSProvider {

    public static final int SPAWNER_ID = 52;

    void spawnEntity(World world, String entityID, double x, double y, double z);

    List<String> rawEntityMap();

    String getMobNameOfSpawner(BlockState blockState);

    boolean setMobNameOfSpawner(BlockState blockState, String entityID);

    void setSpawnersUnstackable();

    ItemStack setNBTEntityID(ItemStack item, String entityID);

    String getSilkSpawnersNBTEntityID(ItemStack item);

    String getVanillaNBTEntityID(ItemStack item);

    Block getSpawnerFacing(Player player, int distance);

    default Collection<? extends Player> getOnlinePlayers() {
        return Bukkit.getOnlinePlayers();
    }

    ItemStack newEggItem(String entityID, int amount);

    @SuppressWarnings("unused")
    default String getVanillaEggNBTEntityID(ItemStack item) {
        return null;
    }

    @SuppressWarnings("unused")
    default void displayBossBar(String title, String colorName, String styleName, Player player, Plugin plugin, int period) {
        return;
    }

    ItemStack getItemInHand(Player player);

    ItemStack getSpawnerItemInHand(Player player);

    void setSpawnerItemInHand(Player player, ItemStack newItem);

    void reduceEggs(Player player);

    Player getPlayer(String playerUUIDOrName);

    default Material getSpawnerMaterial() {
        return Material.MOB_SPAWNER;
    }

    default Material getIronFenceMaterial() {
        return Material.IRON_FENCE;
    }

    default Material getSpawnEggMaterial() {
        return Material.MONSTER_EGG;
    }
}
