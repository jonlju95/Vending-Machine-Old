package se.ec.jonatan.third_app;

import java.util.*;

public class VendingMachineClass implements VendingMachine {
	protected int[] insertableValues;
	private int change;
	private Soda soda;
	private Chips chips;
	private Candy chocolate;
	protected Product[] products;
	protected boolean keepBuying;
	protected ArrayList<Product> boughtProducts;
	
	public VendingMachineClass() {
		insertableValues = new int[] {1, 5, 10, 20, 50, 100, 500, 1000};
		boughtProducts = new ArrayList<Product>();
		soda = new Soda("Coke", "20", "no allergens", "100 calories/litre");
		chips = new Chips("Chips", "60", "can contain traces of lactose" , "300 calories/100g");
		chocolate = new Candy("Chocolate", "140", "can contain traces of nuts", "150 calories/200g");
		products = new Product[3];
		products[0] = soda;
		products[1] = chips;
		products[2] = chocolate;
		keepBuying = true;
		change = 0;
	}
	
	public void addCurrency(int amount) {
		boolean contains = false;
		for(int i : insertableValues) {
            if(i==amount) {
            	contains = true;
            }
        }
		if(contains) {
			change += amount;
			System.out.println("\n----- " + getBalance() + " kr inserted -----\n");
		}
		else {
			System.out.println("Can only add the mentioned values!");
		}
	}

	public int getBalance() {
		return change;
	}
	
	public Product request(int productNumber) {
		if(change<Integer.parseInt(products[productNumber].getCost())) {
			System.out.println("You haven't inserted enough money for that item");
		}
		else { 
			change -= Integer.parseInt(products[productNumber].getCost());
			System.out.println("\nYou buy a " + products[productNumber].getName());
			boughtProducts.add(products[productNumber]);
			System.out.println("Remaining balance is: " + getBalance() + " kr\n");
		}
		return products[productNumber];
	}

	public int endSession() {
		int inReturn = change;
		change = 0;
		keepBuying = false;
		return inReturn;
	}

	public String getDescription(int productNumber) {
		return getProducts()[productNumber];
	}

	public String[] getProducts() {
		String[] stringArr = new String[products.length];
		for(int i=0; i<products.length; i++) {
			stringArr[i] = products[i].examine();
		}
		return stringArr;
	}
}