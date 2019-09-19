package se.ec.jonatan.third_app;

public class Candy extends Product{
	public Candy(String productName, String productCost, String productAllergen, String productCalories) {
		super();
		setName(productName);
		setCost(productCost);
		setAllergens(productAllergen);
		setCalories(productCalories);
	}
}
