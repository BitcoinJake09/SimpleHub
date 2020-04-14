//bitcoinjake09 11/9/2019 - simplehub
package com.simplehub.simplehub;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.event.player.PlayerQuitEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.io.IOException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.*;

public class SimpleHub extends JavaPlugin implements Listener{

  public void onEnable() {
    System.out.println("Enabled SimpleHub");
    getServer().getPluginManager().registerEvents(this, this);
  }

  @Override
  public void onDisable() {
    System.out.println("Disabled SimpleHub");
  }

  @EventHandler
  public void onServerListPing(ServerListPingEvent event) {
    event.setMotd(ChatColor.GOLD + ChatColor.BOLD.toString() + "HUB");
  }

  @EventHandler
  public void onPlayerLogin(PlayerLoginEvent event) {
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
	final Player player = event.getPlayer();
	final String ip = player.getAddress().toString().split("/")[1].split(":")[0];
	System.out.println("User " + player.getName() + "logged in with IP " + ip);
	player.sendMessage(ChatColor.YELLOW + "SERVER LIST: ");
	player.sendMessage(ChatColor.GREEN + "/server Anarchy " + ChatColor.YELLOW + "- A 100% vanilla 1.13.2 anarchy server, hacks & cheats allowed");
	player.sendMessage(ChatColor.GREEN + "/server EmeraldQuest " + ChatColor.YELLOW + "- vanilla 1.13.2, emerald economy, optional pvp, keep inventory, keep lvl, plots, clans & more!");
	player.sendMessage(ChatColor.GREEN + "/server SatoshiQuest " + ChatColor.YELLOW + "- A Bitcoin Minecraft Treasure hunt where players search the vast minecraft landscapes in search of 1 treasure");
	//player.sendMessage(ChatColor.GREEN + "/server LTChunt " + ChatColor.YELLOW + "- A Litecoin Minecraft Treasure hunt where players search the vast minecraft landscapes in search of 1 treasure");
	//player.sendMessage(ChatColor.GREEN + "/server DOGEhunt " + ChatColor.YELLOW + "- A DOGE Minecraft Treasure hunt where players search the vast minecraft landscapes in search of 1 treasure");
	updateScoreboard(player);
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
    }

  @EventHandler
  public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {
	final Player player = event.getPlayer();
	boolean hasOps = false;
	Set<OfflinePlayer> opsList = (Bukkit.getOperators());
	for (OfflinePlayer p : opsList) {
		if (p.getUniqueId().toString().equals(player.getUniqueId().toString())) {
			hasOps = true;
			break;
		}
		if (hasOps == true) {break;}
	}

	if (hasOps == true)		
	event.setCancelled(false);
	else 
	event.setCancelled(true);
	player.sendMessage(ChatColor.RED + "you do not have op.");
	}

  public void updateScoreboard(final Player player) {
	ScoreboardManager scoreboardManager;
	Scoreboard playSBoard;
	Objective playSBoardObj;
	scoreboardManager = Bukkit.getScoreboardManager();
	playSBoard= scoreboardManager.getNewScoreboard();
	playSBoardObj = playSBoard.registerNewObjective("wallet","dummy");
        playSBoardObj.setDisplaySlot(DisplaySlot.SIDEBAR);
        playSBoardObj.setDisplayName(ChatColor.GREEN + ChatColor.BOLD.toString() + "Hub" + ChatColor.GOLD + ChatColor.BOLD.toString() + "Connect");
        Score score0 = playSBoardObj.getScore(ChatColor.GREEN + "/Server Anarchy");
	score0.setScore(0);
        Score score1 = playSBoardObj.getScore(ChatColor.GREEN + "/Server EmeraldQuest");
	score1.setScore(1);
	Score score2 = playSBoardObj.getScore(ChatColor.GREEN + "/Server SatoshiQuest");
	score2.setScore(2);
	player.setScoreboard(playSBoard);
            
       
       
    }

}
