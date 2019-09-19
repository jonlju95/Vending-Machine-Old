package se.ec.jonatan.third_app;

public class Soda extends Product {
	public Soda(String productName, String productCost, String productAllergens, String productCalories) {
		super();
		setName(productName);
		setCost(productCost);
		setAllergens(productAllergens);
		setCalories(productCalories);
	}
}