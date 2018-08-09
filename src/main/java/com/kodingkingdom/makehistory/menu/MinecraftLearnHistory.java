package com.kodingkingdom.makehistory.menu;


import java.util.UUID;
import java.util.function.Supplier;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.kodingkingdom.pager.icons.Icon;
import com.kodingkingdom.pager.page.Menu;

public class MinecraftLearnHistory {
	public static Material material = Material.ENCHANTED_BOOK;
	public static String name = "Minecraft學歷史";
	public static String caption = "中國八大場景"+"\n"+ChatColor.translateAlternateColorCodes('&', "&0") + UUID.randomUUID().toString().substring(0, 8);
	public static ItemStack icon = Icon.makeIcon(material)
			.withName(name)
			.withCaption(caption)
			.asIcon();
	
	
	Menu bible;
	public ItemStack getIcon(){
		return menuIcon.clone();}
	final ItemStack menuIcon;
	public final static long pollInterval=8;
	
	public MinecraftLearnHistory () {
		menuIcon = Icon.makeIcon(material)
				.withName(name)
				.withCaption(caption + "\n"+ChatColor.translateAlternateColorCodes('&', "&0") + UUID.randomUUID().toString().substring(0, 8))
				.asIcon();
		bible=Menu.createMenu(9, 6, "Minecraft學歷史－中國八大場景", menuIcon);
		
		TemplateTopPage book_page = new TemplateTopPage(new Supplier<Player> () {
			public Player get () {
				return bible.current_player;
			}
		}); 
		bible.attach(book_page.makePageConnector(bible.getSubBox(0, 0, 8, 5)));}
}

