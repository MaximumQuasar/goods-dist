package assignment;

import assignment.Item;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

class proc{
	ArrayList<Item> itemsList;
	ArrayList<Integer> difference;
	resource res;
	proc(ArrayList<Item> itemsList, resource res){
		this.itemsList=itemsList;
		this.res=res;
		difference=new ArrayList<Integer>();
	}

	public void run(int n) throws IOException{
		int index=transaction(n,0,itemsList.subList(0,n));
		writeToFile(itemsList.subList(index,n+index),difference.get(index));
		//iterate
		//skip(i+n)
		//max-min
	}

	public int transaction(int n,int i,List<Item> sItemsList){
		difference.add(getDifference(sItemsList,sItemsList.size()-1));

		if(i<(itemsList.size()-n)){
			i++;
			return transaction(n,i,itemsList.subList(i,n+i));
		}
		else
			return difference.indexOf(difference.stream().min(Integer::compare).get());
	}

	public Integer getDifference(List<Item> sItemsList,int size){
		return sItemsList.get(size).price-sItemsList.get(0).price;
		//sItemsList.stream().min(Comparator.comparing(Item::getPrice)).get().price-sItemsList.stream().max(Comparator.comparing(Item::getPrice)).get().price;
	}

	public void writeToFile(List<Item> sItemsList,int diff) throws IOException{
		PrintWriter writer=res.OutputFile();
		
		writer.println("The goodies selected for distribution are:");

		for(Item item: sItemsList)
			writer.println(item);
		writer.println("And the difference between the chosen goodie with highest price and the lowest price is "+diff);
	}
}