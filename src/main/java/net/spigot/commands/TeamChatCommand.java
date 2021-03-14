package net.spigot.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.spigot.utils.ConfigManager;
import net.spigot.utils.MessageManager;

public class TeamChatCommand extends Command {

    public TeamChatCommand() {
        super("teamchat", null, new ConfigManager().getTeamChatAliases().toString());
    }

    ConfigManager configManager = new ConfigManager();
    MessageManager messageManager = new MessageManager();

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;

            if(player.hasPermission(configManager.getTeamChatPermission())) {
                if(args.length > 0) {
                    // Setting the message
                    String message = "";
                    for (int i = 0; i < args.length; i++) {
                        message = message + args[i] + " ";
                    }
                    //

                    // Sending to the players
                    for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                        if(players.hasPermission(configManager.getTeamChatPermission())) {
                            players.sendMessage(new TextComponent(messageManager.getTeamChatFormat(player.getServer().getInfo().getName(), player.getName(), message)));
                        }
                    }
                    //
                }
            } else {
                player.sendMessage(new TextComponent(messageManager.getMissingPermission()));
            }
        }
    }
}
