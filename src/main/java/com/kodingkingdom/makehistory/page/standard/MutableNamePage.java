package com.kodingkingdom.makehistory.page.standard;

import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.kodingkingdom.makehistory.icons.Icon;
import com.kodingkingdom.makehistory.menu.MinecraftLearnHistory;
import com.kodingkingdom.makehistory.page.select.MutableSelectItemCategoryPage;
import com.kodingkingdom.makehistory.page.select.SelectItem;

public class MutableNamePage extends MutableSelectItemCategoryPage{
	
	public MutableNamePage(Supplier<String> nameGetter, int height) {
		super(
			()->{
				return nameGetter.get().chars().mapToObj(ch -> (char)ch)
						.map((Character ch)->{return new SelectItem(()->{}, Icon.makeIcon(""+ch).asIcon());})
						.collect(Collectors.toList());}
			, MinecraftLearnHistory.pollInterval);}}
