package net.glowstone.command.minecraft;

import net.glowstone.command.CommandUtils;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.VanillaCommand;

import java.util.Collections;

public class SeedCommand extends VanillaCommand {
    public SeedCommand() {
        super("seed", "Displays the world seed.", "/seed", Collections.emptyList());
        setPermission("minecraft.command.seed");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!testPermission(sender)) return false;

        final World world = CommandUtils.getWorld(sender);

        if (world == null) {
            return false;
        } else {
            sender.sendMessage("Seed: " + world.getSeed());
        }

        return true;
    }
}
