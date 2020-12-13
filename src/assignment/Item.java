package assignment;

class Item implements Comparable<Item>{
	public String name;
	public int price;

	Item(String name,int price){
		this.name=name;
		this.price=price;	
	}
	
	public int compareTo(Item item){
		return item.price<this.price?1:(item.price>this.price?-1:0);
	}
	
	public Integer getPrice(){
		return this.price;
	}

	@Override
	public String toString(){
		return name+": "+price;
	}
}