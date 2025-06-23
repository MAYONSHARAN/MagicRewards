package com.may0n.magicrewards;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getCommand("rewards").setExecutor(new RewardsCommand());
        getServer().getPluginManager().registerEvents(new RewardsGUI(), this);
        getLogger().info("MagicRewards plugin enabled.");
    }

    public static Main getInstance() {
        return instance;
    }
}
