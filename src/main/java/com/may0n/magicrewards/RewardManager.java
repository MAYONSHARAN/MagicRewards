package com.may0n.magicrewards;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class RewardManager {

    public static void giveReward(Player player, String type) {
        FileConfiguration config = Main.getInstance().getConfig();

        // Check if reward commands are defined
        if (!config.contains("rewards." + type + ".commands")) {
            player.sendMessage("No reward found for type: " + type);
            return;
        }

        // Execute each reward command
        for (String cmd : config.getStringList("rewards." + type + ".commands")) {
            String parsed = cmd.replace("{player}", player.getName());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), parsed);
        }

        // Send claim message
        String prefix = config.getString("prefix", "");
        String msg = config.getString("messages.claimed", "")
                .replace("{type}", type)
                .replace("{prefix}", prefix);
        player.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', msg));
    }
                                        }
