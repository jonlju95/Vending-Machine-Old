package se.ec.jonatan.third_app;

public abstract class Product {
	protected String name;
	protected String cost;
	protected String allergen;
	protected String calory;
	
	public Product(String productName, String productCost, String allergens, String calories) {
		name = productName;
		cost = productCost;
		allergen = allergens;
		calory = calories;
	}
	
	public String examine() {
		StringBuilder temp = new StringBuilder();
		temp.append(name + ", " + cost + " kr, " + allergen + ", " + calory);
		return temp.toString();
	}
	
	public String use() {
		return name + " used";
	}
}