package com.kodingkingdom.makehistory.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.javatuples.Pair;

import com.kodingkingdom.pager.icons.Icon;
import com.kodingkingdom.pager.icons.Icon.Textures;
import com.kodingkingdom.pager.page.CompositeBoxPage;
import com.kodingkingdom.pager.page.Menu;
import com.kodingkingdom.pager.page.select.Layout;
import com.kodingkingdom.pager.page.select.SelectItem;
import com.kodingkingdom.pager.page.select.SelectItemCategoryPage;

public class TemplateTopPage extends CompositeBoxPage {
	
	Supplier<Player> player;
	Collection<Pair<ItemStack,TemplateDynastyPage>> dynasties;
	
	//TODO: make configurable
	public TemplateTopPage(Supplier<Player> player){
		this .player = player;
		this .dynasties = Arrays.asList(
				new Pair<ItemStack,TemplateDynastyPage> (Icon.makeIcon(Textures.light_gray).withName("先秦").asIcon(), new TemplateDynastyPage (Arrays.asList(
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("大禹治水").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("草屋").asIcon(), "02_W")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("烽火戲諸侯").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("烽火台").asIcon(), "03_complete_E")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("孔子周遊列國").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("先秦馬車").asIcon(), "04_complete_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.light_gray).withName("先秦馬車").asIcon(), "04_extra_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.light_gray).withName("先秦馬車").asIcon(), "04_parts01_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.light_gray).withName("先秦馬車").asIcon(), "04_parts02_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("先秦馬車").asIcon(), "04b_complete_E")
						)))
				))),
				new Pair<ItemStack,TemplateDynastyPage> (Icon.makeIcon(Textures.dark_gray).withName("秦漢").asIcon(), new TemplateDynastyPage (Arrays.asList(
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("孟姜女哭崩長城").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("長城").asIcon(), "05_parts01_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("長城").asIcon(), "05_parts02_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("長城").asIcon(), "05_parts03_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("長城").asIcon(), "05b_complete_S"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("長城").asIcon(), "05b_parts01_W")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("焚書坑儒").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("咸陽宮").asIcon(), "06_complete_N")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("張騫通西域").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("未央宮").asIcon(), "08_complete_S"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("未央宮").asIcon(), "08_parts01_S"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("未央宮").asIcon(), "08_parts02_S"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("未央宮").asIcon(), "08b_complete_E")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("三英戰呂布").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("虎牢關").asIcon(), "09_complete_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("虎牢關").asIcon(), "09_parts02_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("虎牢關").asIcon(), "09_parts03_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("虎牢關").asIcon(), "09b_complete_E")
						)))
				))),
				new Pair<ItemStack,TemplateDynastyPage> (Icon.makeIcon(Textures.purple).withName("魏晉").asIcon(), new TemplateDynastyPage (Arrays.asList(
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("佛教東傳").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("磚壁畫墓").asIcon(), "11_complete_E")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("木蘭辭").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("明堂").asIcon(), "12a_complete_S"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("明堂").asIcon(), "12a_part01_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("明堂").asIcon(), "12a_parts02_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("明堂").asIcon(), "12a_parts03_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("明堂").asIcon(), "12b_complete_S")
						)))
				))),
				new Pair<ItemStack,TemplateDynastyPage> (Icon.makeIcon(Textures.red).withName("隋唐").asIcon(), new TemplateDynastyPage (Arrays.asList(
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("佛教東傳").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("南禪寺").asIcon(), "14_complete_W")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("玄武門之變").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("城門").asIcon(), "16_complete_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("城門").asIcon(), "16_parts01_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("城門").asIcon(), "16_parts02_C")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("長安的一天").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("隋唐平民住宅").asIcon(), "17_complete_E")
						)))
				))),
				new Pair<ItemStack,TemplateDynastyPage> (Icon.makeIcon(Textures.yellow).withName("宋元").asIcon(), new TemplateDynastyPage (Arrays.asList(
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("黃袍加身").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("軍帳").asIcon(), "18_complete_W"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("軍帳").asIcon(), "18_parts01_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("軍帳").asIcon(), "18b_complete_E")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("包青天").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("縣衙").asIcon(), "19_complete_S"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("縣衙").asIcon(), "19_parts01_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("縣衙").asIcon(), "19_parts02_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("縣衙").asIcon(), "19_parts03_N")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("蒙古西征").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("蒙古包").asIcon(), "20_parts01_W"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("蒙古包").asIcon(), "20_parts02_W"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("蒙古包").asIcon(), "20_parts03_W"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("蒙古包").asIcon(), "20b_complete_W")
						)))
				))),
				new Pair<ItemStack,TemplateDynastyPage> (Icon.makeIcon(Textures.blue).withName("明清").asIcon(), new TemplateDynastyPage (Arrays.asList(
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("鄭和下西洋").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("明代官服、瓷器").asIcon(), "21a_complete_S"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("明代官服、瓷器").asIcon(), "21b_complete_W")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("乾隆下江南").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("江南民居").asIcon(), "22_complete_E")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("紅樓夢").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("北京四合院").asIcon(), "23_complete_S"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("北京四合院").asIcon(), "23_parts01_E"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("北京四合院").asIcon(), "23_parts02_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("北京四合院").asIcon(), "23_parts03_N"),
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.wooden_crate).withName("北京四合院").asIcon(), "23_parts04_N")
						))),
						new Pair<ItemStack,TemplateBuildingPage> (Icon.makeIcon(Textures.set).withName("虎門銷煙").asIcon(), new TemplateBuildingPage (player, Arrays.asList(
								new Pair<ItemStack,String> (Icon.makeIcon(Textures.blue_crate).withName("清代官員服裝").asIcon(), "24_complete_W")
						)))
				)))
		);
	}
	protected void compositeAttachedAction(Connector connector){
		TemplateTopPage self = TemplateTopPage.this;
		SelectItemCategoryPage contentPage = new SelectItemCategoryPage(
				Layout.flow(
					new ArrayList<SelectItem> () {{
						addAll (	dynasties.stream()
							.map(pair->
									new SelectItem(()->{
										self.attach(pair.getValue1()
												.makePageConnector(self.getSubBox(0,0,self.getWidth()-1, self.getHeight()-1)));
									}, pair.getValue0()))
							.collect(Collectors.toList()));
						/*add (new SelectItem(()->{
							Player p = player.get();
							CommandLine.eval(p, Arrays.asList(
								"/undo"
							));
							p .sendMessage("Undo completed");
						}, Icon.makeIcon(Textures.Back).withName("Undo").asIcon()));*/
					}}
					, self.getWidth(), self .getHeight())
		);
		self.compose(contentPage.makePageConnector(self.getSubBox(0, 0, self.getWidth()-1, self.getHeight()-1)));}}
