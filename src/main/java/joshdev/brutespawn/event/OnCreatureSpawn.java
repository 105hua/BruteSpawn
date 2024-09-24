/* Licensed under the GNU General Public License v3.0 */
package joshdev.brutespawn.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import joshdev.brutespawn.BruteSpawn;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class OnCreatureSpawn implements Listener {

  private final ArrayList<Biome> validBiomes =
      new ArrayList<>(
          Arrays.asList(
              Biome.NETHER_WASTES,
              Biome.SOUL_SAND_VALLEY,
              Biome.CRIMSON_FOREST,
              Biome.WARPED_FOREST,
              Biome.BASALT_DELTAS));

  @EventHandler(ignoreCancelled = true)
  public void onCreatureSpawn(CreatureSpawnEvent event) {
    if (event.getEntity().getType() != EntityType.PIGLIN) return;
    if (!validBiomes.contains(event.getEntity().getLocation().getBlock().getBiome())) return;
    if (event.getEntity().getLocation().getBlockY() >= 120) return;
    if (event.getEntity().getLocation().getBlock().getType() == Material.NETHER_BRICK) return;
    if (new Random().nextInt(BruteSpawn.spawnChance) != 0) return;
    event.setCancelled(true);
    event
        .getEntity()
        .getWorld()
        .spawnEntity(
            event.getEntity().getLocation().clone(),
            EntityType.PIGLIN_BRUTE,
            event.getSpawnReason());
  }
}
