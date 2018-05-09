package com.kodingkingdom.makehistory;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import com.kodingkingdom.makehistory.commandline.CommandLine;
import com.kodingkingdom.makehistory.icons.Icon;
import com.kodingkingdom.makehistory.menu.MinecraftLearnHistory;
import com.kodingkingdom.makehistory.menu.TemplateBuildingPage;

public class Template implements Listener{

	TemplatePlugin plugin;	
	public Template(TemplatePlugin Plugin){plugin=Plugin;}
	
	//TODO: handle cases of old book already on hand, aka onheld event not fired
	public void Live(){
		CommandLine.go();
		//plugin.getCommand("mkh").setExecutor(this);
		registerEvents(this);}
	
	public void Die(){}
	
	public void registerEvents(Listener listener){
		plugin.getServer().getPluginManager().registerEvents(listener, plugin);}

	public int scheduleAsyncTask(Runnable task){
		return plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, task);}
	public int scheduleAsyncTask(Runnable task, long delay){
		return plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, task, delay);}
	public int scheduleTask(Runnable task, long delay){
		return plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, task, delay);}
	public void cancelTask(int taskId){
		plugin.getServer().getScheduler().cancelTask(taskId);}

	@EventHandler
	public void subsidize_bible(PlayerJoinEvent e){
		this.subsidize_bible(e.getPlayer());}
	
	private void subsidize_bible(Player player){
		int slotNumber = 0;
		for (;slotNumber<player.getInventory().getSize();slotNumber++){
			if (Icon.like (player.getInventory().getItem(slotNumber), MinecraftLearnHistory.icon)) return;
		}
		
		MinecraftLearnHistory newBible = new MinecraftLearnHistory();
		//TemplatePlugin.debug("new bible is "+newBible);
		
		slotNumber = 0;
		for (;slotNumber<player.getInventory().getSize();slotNumber++){
			if (player.getInventory().getItem(slotNumber)==null) break;}
		
		if (slotNumber<player.getInventory().getSize()) {
			//TemplatePlugin.debug("put bible in slot "+slotNumber);
			player.getInventory().setItem(slotNumber,newBible.getIcon());}
		else {
			//TemplatePlugin.debug("put bible in hand");
			player.setItemInHand(newBible.getIcon());}
		player.updateInventory();
	}

	public void buy_in(Player p){
		ItemStack book = p.getInventory().getItemInHand();
		if (Icon.like(book, MinecraftLearnHistory.icon) && ! Icon.is(book, MinecraftLearnHistory.icon)) {
			MinecraftLearnHistory bible = new MinecraftLearnHistory();
			p.getPlayer().getInventory().setItemInHand(bible.getIcon());;
		}
	}
	@EventHandler
	public void bless_bibles(PlayerItemHeldEvent e){
		ItemStack book = e.getPlayer().getInventory().getItem(e.getNewSlot());
		if (Icon.like(book, MinecraftLearnHistory.icon) && ! Icon.is(book, MinecraftLearnHistory.icon)) {
			MinecraftLearnHistory bible = new MinecraftLearnHistory();
			e.getPlayer().getInventory().setItem(e.getNewSlot(),bible.getIcon());
		}
	}
}
