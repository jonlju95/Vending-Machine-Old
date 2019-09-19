package se.ec.jonatan.third_app;

public abstract class Product {
	private String name;
	private String cost;
	private String allergen;
	private String calory;
	
	public Product() {}
	
	public void setName(String productName) {
		name = productName;
	}
	
	public String getName() {
		return name;
	}

	public void setCost(String productCost) {
		cost = productCost;
	}
	
	public String getCost() {
		return cost;
	}
	
	public void setAllergens(String productAllergen) {
		allergen = productAllergen;
	}
	
	public String getAllergens() {
		return allergen;
	}
	
	public void setCalories(String productCalory) {
		calory = productCalory;
	}
	
	public String getCalories() {
		return calory;
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