package se.ec.jonatan.third_app;

public class Chips extends Product{
	public Chips(String productName, String productCost, String productAllergen, String productCalories) {
		super();
		setName(productName);
		setCost(productCost);
		setAllergens(productAllergen);
		setCalories(productCalories);
	}
}