package com.kodingkingdom.makehistory.page.standard;

import java.util.stream.Collectors;

import com.kodingkingdom.makehistory.icons.Icon;
import com.kodingkingdom.makehistory.page.select.Layout;
import com.kodingkingdom.makehistory.page.select.SelectItem;
import com.kodingkingdom.makehistory.page.select.SelectItemCategoryPage;

public class NamePage extends SelectItemCategoryPage{
	public NamePage(String name, int height) {
		super (Layout .flow (
			name .chars () .mapToObj(c -> (char) c)
				.map(char_->new SelectItem(()->{}, Icon.makeIcon(""+char_).asIcon()))
				.collect(Collectors.toList())
			, 1, height));
	}
}
