package com.kodingkingdom.makehistory.page.select;

public class SelectItemCategoryPage extends CategoryPage<SelectItem>{
	public SelectItemCategoryPage(SelectItem[][] SelectItems){
		super(SelectItems
				,(SelectItem selectItem)->{return selectItem;});}}
