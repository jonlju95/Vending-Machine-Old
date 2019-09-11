package se.ec.jonatan.third_app;

public abstract class Product {
	protected String name;
	protected String cost;
	
	public Product(String productName, String productCost) {
		name = productName;
		cost = productCost;
	}
	
	public String examine() {
		StringBuilder temp = new StringBuilder();
		temp.append(name + ", " + cost);
		return temp.toString();
	}
	
	public String use() {
		return null;
	}
}