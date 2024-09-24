/* Licensed under the <LICENSE> */
package joshdev.brutespawn.commands;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import joshdev.brutespawn.BruteSpawn;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.incendo.cloud.annotations.Command;
import org.incendo.cloud.annotations.CommandDescription;
import org.incendo.cloud.annotations.Permission;

public class ReloadCommand {

  private final TextComponent successComponent =
      Component.text("Successfully reloaded the configuration file.", NamedTextColor.GREEN);

  private final TextComponent failureComponent =
      Component.text(
          "Failed to reload the configuration file, using default spawn chance of 20.",
          NamedTextColor.RED);

  @Command("reload")
  @CommandDescription("Reload the plugins configuration file.")
  @Permission("brutespawn.reload")
  @SuppressWarnings("unused")
  public void reloadCommand(CommandSourceStack sourceStack) {
    CommandSender sender = sourceStack.getSender();
    if (!(sender instanceof Player player)) {
      sender.sendMessage("You must be a player to run this command.");
      return;
    }
    try {
      BruteSpawn.spawnChance = BruteSpawn.pluginInstance.getConfig().getInt("chance");
      player.sendMessage(successComponent);
    } catch (Exception exc) {
      BruteSpawn.spawnChance = 20;
      player.sendMessage(failureComponent);
    }
  }
}
