package com.kodingkingdom.makehistory.menu;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.bukkit.inventory.ItemStack;
import org.javatuples.Pair;

import com.kodingkingdom.makehistory.page.CompositeBoxPage;
import com.kodingkingdom.makehistory.page.select.Layout;
import com.kodingkingdom.makehistory.page.select.SelectItem;
import com.kodingkingdom.makehistory.page.select.SelectItemCategoryPage;
import com.kodingkingdom.makehistory.page.standard.ControlsPage;

public class TemplateDynastyPage extends CompositeBoxPage {
	Collection<Pair<ItemStack,TemplateBuildingPage>> buildings;
	public TemplateDynastyPage(Collection<Pair<ItemStack, TemplateBuildingPage>> buildings){this .buildings = buildings;}
	protected void compositeAttachedAction(Connector connector){
		final TemplateDynastyPage self = TemplateDynastyPage.this;
		SelectItemCategoryPage contentPage = new SelectItemCategoryPage(Layout.flow(
				buildings.stream()
					.map(pair->
							new SelectItem(()->{
								self.attach(pair.getValue1()
										.makePageConnector(self.getSubBox(0,0,self.getWidth()-1, self.getHeight()-1)));
							}, pair.getValue0()))
					.collect(Collectors.toList())
				, self.getWidth(), self .getHeight() - 1));
		ControlsPage controlsPage = new ControlsPage (() -> {
			self.remove();
		}, null, null, null, null, null, null, null);
		this.compose(contentPage.makePageConnector(self.getSubBox(0, 0, self.getWidth()-1, self.getHeight()-2)));
		this.compose(controlsPage.makePageConnector(self.getSubBox(0, self.getHeight()-1,7, self.getHeight()-1)));
		this.compose(new SelectItemCategoryPage(Layout.flow(Arrays.asList(),self.getWidth()-8,1)).makePageConnector(self.getSubBox(8, self.getHeight()-1,self.getWidth()-1,self.getHeight()-1)));}}
