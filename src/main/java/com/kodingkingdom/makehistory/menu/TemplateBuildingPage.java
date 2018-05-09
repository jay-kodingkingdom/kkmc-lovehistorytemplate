package com.kodingkingdom.makehistory.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.javatuples.Pair;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.kodingkingdom.makehistory.TemplatePlugin;
import com.kodingkingdom.makehistory.commandline.CommandLine;
import com.kodingkingdom.makehistory.icons.Icon;
import com.kodingkingdom.makehistory.icons.Icon.Textures;
import com.kodingkingdom.makehistory.page.CompositeBoxPage;
import com.kodingkingdom.makehistory.page.select.Layout;
import com.kodingkingdom.makehistory.page.select.SelectItem;
import com.kodingkingdom.makehistory.page.select.SelectItemCategoryPage;
import com.kodingkingdom.makehistory.page.standard.ControlsPage;

public class TemplateBuildingPage extends CompositeBoxPage {
	
	Supplier<Player> player;
	Collection<Pair<ItemStack,String>> schemas;
	public TemplateBuildingPage(Supplier<Player> player, Collection<Pair<ItemStack, String>> schemas){this .player = player; this .schemas = schemas;}
	protected void compositeAttachedAction(Connector connector){
		final TemplateBuildingPage self = TemplateBuildingPage.this;
		SelectItemCategoryPage contentPage = new SelectItemCategoryPage(Layout.flow(
				new ArrayList<SelectItem> () {{
					addAll(schemas.stream()
						.map(pair->
								new SelectItem(()->{
									Player p = player.get();
									CommandLine.eval(p, Arrays.asList(
										"/schematic load " + pair.getValue1(),
										"/paste -a"
									));
									p .sendMessage("Finished building");
									/*try {
										TemplatePlugin.debug("drawing schematic " + pair.getValue1());
										File file = new File(Bukkit.getServer().getPluginManager().getPlugin("WorldEdit").getDataFolder(), "/schematics/" + pair.getValue1() + ".schematic"); // The schematic file
										TemplatePlugin.debug("at location " + player.getLocation().getBlockX()+", "+player.getLocation().getBlockY()+", "+player.getLocation().getBlockZ());
										Vector to = new Vector(player.getLocation().getBlockX(),player.getLocation().getBlockY(),player.getLocation().getBlockZ()); // Where you want to paste
		
										World weWorld = new BukkitWorld(player.getWorld());
										WorldData worldData = weWorld.getWorldData();
										Clipboard clipboard = ClipboardFormat.SCHEMATIC.getReader(new FileInputStream(file)).read(worldData);
										Region region = clipboard.getRegion();
		
										Extent extent = WorldEdit.getInstance().getEditSessionFactory().getEditSession(weWorld, -1);
										AffineTransform transform = new AffineTransform();
		
										//{ // Uncomment this if you want to rotate the schematic
		//								    transform = transform.rotateY(90); // E.g. rotate 90
		//								    extent = new BlockTransformExtent(clipboard, transform, worldData.getBlockRegistry());
										//}
		
										ForwardExtentCopy copy = new ForwardExtentCopy(extent, clipboard.getRegion(), clipboard.getOrigin(), extent, to);
										if (!transform.isIdentity()) copy.setTransform(transform);
									    copy.setSourceMask(new ExistingBlockMask(clipboard));
										Operations.completeLegacy(copy);
									}
									catch (Exception e) {
										TemplatePlugin.debug(e.getMessage());
									}*/
								}, pair.getValue0()))
						.collect(Collectors.toList()));
					add (new SelectItem(()->{
						Player p = player.get();
						CommandLine.eval(p, Arrays.asList(
							"/undo"
						));
						p .sendMessage("Undo completed");
					}, Icon.makeIcon(Textures.Back).withName("Undo").asIcon()));
				}}
				, self.getWidth(), self .getHeight() - 1));
		ControlsPage controlsPage = new ControlsPage (() -> {
			self.remove();
		}, null, null, null, null, null, null, null);
		this.compose(contentPage.makePageConnector(self.getSubBox(0, 0, self.getWidth()-1, self.getHeight()-2)));
		this.compose(controlsPage.makePageConnector(self.getSubBox(0, self.getHeight()-1,7,self.getHeight()-1)));
		this.compose(new SelectItemCategoryPage(Layout.flow(Arrays.asList(),self.getWidth()-8,1)).makePageConnector(self.getSubBox(8, self.getHeight()-1,self.getWidth()-1,self.getHeight()-1)));}}
