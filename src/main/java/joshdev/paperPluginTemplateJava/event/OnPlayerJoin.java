/* Licensed under the <LICENSE> */
package joshdev.paperPluginTemplateJava.event;

import joshdev.paperPluginTemplateJava.PaperPluginTemplateJava;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    TextComponent welcomeComponent =
        Component.text(
            "Welcome to the server, " + player.getName() + "!",
            NamedTextColor.YELLOW,
            TextDecoration.BOLD);
    PaperPluginTemplateJava.pluginInstance.getServer().broadcast(welcomeComponent);
  }
}
