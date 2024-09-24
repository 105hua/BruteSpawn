/* Licensed under the <LICENSE> */
package joshdev.paperPluginTemplateJava.commands;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.CommandSender;
import org.incendo.cloud.annotations.Command;
import org.incendo.cloud.annotations.CommandDescription;
import org.incendo.cloud.annotations.Permission;

public class ExampleCommand {

  @Command("example")
  @CommandDescription("An example command. This is the description.")
  @Permission("paperplugintemplate.example")
  @SuppressWarnings("unused")
  public void exampleCommand(CommandSourceStack sourceStack) {
    CommandSender sender = sourceStack.getSender();
    TextComponent exampleComponent =
        Component.text(
            "Hello! This is an example command!", NamedTextColor.GREEN, TextDecoration.BOLD);
    sender.sendMessage(exampleComponent);
  }
}
