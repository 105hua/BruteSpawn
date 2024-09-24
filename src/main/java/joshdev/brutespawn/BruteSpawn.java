/* Licensed under the GNU General Public License v3.0 */
package joshdev.brutespawn;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import joshdev.brutespawn.commands.ReloadCommand;
import joshdev.brutespawn.event.OnCreatureSpawn;
import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.cloud.annotations.AnnotationParser;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.paper.PaperCommandManager;

public final class BruteSpawn extends JavaPlugin {

  public static BruteSpawn pluginInstance;
  public static PaperCommandManager<CommandSourceStack> commandManager;
  public static AnnotationParser<CommandSourceStack> annotationParser;
  public static int spawnChance;

  @Override
  public void onEnable() {
    // Save the config in the jar.
    saveDefaultConfig();
    // Load the spawn chance from the config.
    try {
      spawnChance = getConfig().getInt("spawn-chance");
    } catch (Exception e) {
      getLogger().warning("Error loading config, using default spawn chance of 20.");
      spawnChance = 20;
    }
    // Defines a variable of the plugin that can be accessed in other classes.
    pluginInstance = this;
    // Creates the command manager and annotation parser.
    commandManager =
        PaperCommandManager.builder()
            .executionCoordinator(ExecutionCoordinator.simpleCoordinator())
            .buildOnEnable(this);
    annotationParser = new AnnotationParser<>(commandManager, CommandSourceStack.class);
    annotationParser.parse(new ReloadCommand());
    getServer().getPluginManager().registerEvents(new OnCreatureSpawn(), this);
    // Log that the plugin has been enabled.
    getLogger().info("Plugin has been enabled!");
  }

  @Override
  public void onDisable() {
    // Log that the plugin has been disabled.
    getLogger().info("Plugin has been disabled!");
  }
}
