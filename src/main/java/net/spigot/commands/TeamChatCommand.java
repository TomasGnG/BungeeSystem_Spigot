package net.spigot.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.spigot.utils.ConfigManager;

public class TeamChatCommand extends Command {

    public TeamChatCommand(String name, String permission, String... aliases) {
        super("teamchat", null, new ConfigManager().getTeamChatAliases().toString());
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {

    }
}
