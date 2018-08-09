package com.kodingkingdom.makehistory.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.javatuples.Pair;

import com.kodingkingdom.commandline.kinds.SilentCommandLine;
import com.kodingkingdom.pager.icons.Icon;
import com.kodingkingdom.pager.icons.Icon.Textures;
import com.kodingkingdom.pager.page.CompositeBoxPage;
import com.kodingkingdom.pager.page.select.Layout;
import com.kodingkingdom.pager.page.select.SelectItem;
import com.kodingkingdom.pager.page.select.SelectItemCategoryPage;
import com.kodingkingdom.pager.page.standard.ControlsPage;

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
									List<String> build = new ArrayList <String> (Arrays.asList(
										"/schematic load " + pair.getValue1()));
									
									String rotation = rotate (pair.getValue1().substring(pair.getValue1().length() - 1),cardinal_direction (p));
									
									if (rotation != "")
										build .addAll (Arrays .asList (rotation));

									build .addAll (Arrays .asList ("/paste -a"));
										
									if (p.isOp()) {
										ArrayList<String> x = new ArrayList<String> ();
										x .addAll (Arrays .asList ("p weanywhere"));
										x .addAll (build);
										x .addAll (Arrays .asList ("p weanywhere"));
										build = x;}
									
									SilentCommandLine.eval (p, build);
									p .sendMessage("Finished building");
								}, pair.getValue0()))
						.collect(Collectors.toList()));
					add (new SelectItem(()->{
						Player p = player.get();
						SilentCommandLine.eval(p, Arrays.asList(
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
		this.compose(new SelectItemCategoryPage(Layout.flow(Arrays.asList(),self.getWidth()-8,1)).makePageConnector(self.getSubBox(8, self.getHeight()-1,self.getWidth()-1,self.getHeight()-1)));}
	
	public String rotate (String from, String to) {
//		TemplatePlugin.debug(from);
//		TemplatePlugin.debug(to);

		int from_Z4;

		if (from .equals ("E")) from_Z4 = 0;
		else if (from .equals ("S")) from_Z4 = 1;
		else if (from .equals ("W")) from_Z4 = 2;
		else if (from .equals ("N")) from_Z4 = 3;
		else return "";
//		TemplatePlugin.debug("" + from_Z4);

		int to_Z4;
		
		if (to .equals ("E")) to_Z4 = 0;
		else if (to .equals ("S")) to_Z4 = 1;
		else if (to .equals ("W")) to_Z4 = 2;
		else if (to .equals ("N")) to_Z4 = 3;
		else return "";
//		TemplatePlugin.debug("" + to_Z4);
		
		
		
		if (from_Z4 == to_Z4)
			return "";
		else {
			int diff = (to_Z4 - from_Z4 + 4) % 4;
			return "/rotate " + (90 * diff);
		}
	}
	
	public String cardinal_direction (Player p){
        float y = p.getLocation().getYaw();

        if ( y < 0 ) y += 360;
        y %= 360;
        int i = (int)((y+8) / 90);
        
        if (i == 0) return "W";
        else if(i == 1) return "N";
        else if(i == 2) return "E";
        else if(i == 3) return "S";
        else return "W";
   }}
