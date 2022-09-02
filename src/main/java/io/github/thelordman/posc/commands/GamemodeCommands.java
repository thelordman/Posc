package io.github.thelordman.posc.commands;

import io.github.thelordman.posc.utilities.CommandName;
import io.github.thelordman.posc.utilities.Methods;
import io.github.thelordman.posc.utilities.Rank;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@CommandName("gmc")
public class GamemodeCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!Rank.hasPermission(sender, (byte) 5)) return true;

        GameMode mode;
        switch (cmd.getName()) {
            case "gmc":
                mode = GameMode.CREATIVE;
                break;
            case "gms":
                mode = GameMode.SURVIVAL;
                break;
            case "gma":
                mode = GameMode.ADVENTURE;
                break;
            case "gmsp":
                mode = GameMode.SPECTATOR;
                break;
            default:
                return false;
        }

        return updateMode(args.length > 0 ? Bukkit.getPlayer(args[0]) : (Player) sender, sender, mode);
    }

    private boolean updateMode(Player target, CommandSender sender, GameMode mode) {
        if (target == null) {
            return false;
        }

        target.setGameMode(mode);
        target.sendMessage(Methods.cStr("&6Your gamemode was changed to &f" + Methods.rfStr(mode.name()) + "&6."));

        if (target != sender) {
            sender.sendMessage(Methods.cStr("&f" + target.getDisplayName() + "'s &6gamemode was changed to &f" + Methods.rfStr(mode.name()) + "&6."));
        }

        return true;
    }
}
