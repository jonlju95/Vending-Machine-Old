package se.ec.jonatan.third_app;

public class ActualVendingMachine implements VendingMachine {
	protected int[] insertableValues;
	private int change;
	private Product soda;
	private Product chips;
	private Product chocolate;
	private Product[] test;
	protected boolean keepBuying;
	
	public ActualVendingMachine() {
		insertableValues = new int[] {1, 5, 10, 20, 50, 100, 500, 1000};
		change = 0;
		soda = new FoodItem("Coke", "20");
		chips = new FoodItem("OLW", "60");
		chocolate = new FoodItem("Marabou", "140");
		test = new Product[3];
		test[0] = soda;
		test[1] = chips;
		test[2] = chocolate;
		keepBuying = true;
	}
	
	public void addCurrency(int amount) {
		change += amount;
	}

	public int getBalance() {
		return change;
	}
	
	public Product request(int productNumber) {
		if(change<Integer.parseInt(test[productNumber].cost)) {
			System.out.println("You haven't inserted enough money for that item");
		}
		else { 
			change -= Integer.parseInt(test[productNumber].cost);
			System.out.println("You buy a " + test[productNumber].name);
			System.out.println("Remaining balance is: " + getBalance());
		}
		return test[productNumber];
	}

	public int endSession() {
		int inReturn = change;
		change = 0;
		keepBuying = false;
		return inReturn;
	}

	public String getDescription(int productNumber) {
		return test[productNumber].examine();
	}

	public String[] getProducts() {
		String[] stringArr = new String[test.length];
		for(int i=0; i<1; i++) {
			stringArr[i] = getDescription(i);
		}
		return stringArr;
	}

}
