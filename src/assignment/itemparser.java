package assignment;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import assignment.Item;

class itemParser{
	
	public static Item parse(String parse){
		Pattern pattern=Pattern.compile("(?<name>.+):\\s(?<price>\\d+)");
		Matcher matcher=pattern.matcher(parse);
		
		Item item=null;
		String name;
		int price;
		while(matcher.find()){
			name=matcher.group("name");
			price=Integer.parseInt(matcher.group("price"));
			item=new Item(name,price);
		}
		return item;
	}
}