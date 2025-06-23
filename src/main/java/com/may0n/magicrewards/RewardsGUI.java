package com.may0n.magicrewards;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RewardsGUI implements Listener {
    public static void openMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, ChatColor.GRAY + "Daily Reward: " + ChatColor.GREEN + "Useable!");

        ItemStack filler = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(" ");
        filler.setItemMeta(fillerMeta);

        for (int i = 0; i < 27; i++) {
            gui.setItem(i, filler);
        }

        ItemStack reward = new ItemStack(Material.BEACON);
        ItemMeta rewardMeta = reward.getItemMeta();
        rewardMeta.setDisplayName(ChatColor.AQUA + "Claim Daily Reward");
        reward.setItemMeta(rewardMeta);
        gui.setItem(13, reward);

        player.openInventory(gui);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getView().getTitle().contains("Daily Reward")) {
            event.setCancelled(true);
            if (event.getRawSlot() == 13 && event.getWhoClicked() instanceof Player) {
                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.GREEN + "You claimed your daily reward!");
                event.getWhoClicked().closeInventory();
            }
        }
    }
}
