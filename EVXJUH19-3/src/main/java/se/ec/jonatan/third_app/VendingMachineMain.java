package se.ec.jonatan.third_app;

import java.util.Scanner;

public class VendingMachineMain {
	public static void main(String[] args) {
		ActualVendingMachine test = new ActualVendingMachine();
		Scanner in = new Scanner(System.in);
		int option;
		System.out.println("Welcome! ");
		while(test.keepBuying) {
			System.out.println("Choose an option: \n1: Add money \n2: Select an item to buy"
								+ "\n3: Examine an item without buying \nSelection: ");
			option = Integer.parseInt(in.nextLine());
			switch (option) {
				case 1: 
					System.out.print("Amount: ");
					test.addCurrency(Integer.parseInt(in.nextLine()));
					System.out.println("\n----- " + test.getBalance() + " kr inserted -----\n");
					break;
				case 2:
					System.out.println();
					for(int i=0; i<test.getProducts().length; i++) {
						System.out.println(i+1 + ": " + test.getDescription(i));
					}
					System.out.print("Selection: ");
					int item = Integer.parseInt(in.nextLine())-1;
					test.request(item);
					break;
				case 3: 
					System.out.println("1: Soda \n2: Chips \n3: Chocolate ");
					System.out.print("\nOption: ");
					item = Integer.parseInt(in.nextLine())-1;
					System.out.println(test.getDescription(item) + "\n");
					break;
				default: 
					System.out.println("Thank you for your purchase! Here is your change: "
							+ test.getBalance() + " kr returned!");
					test.endSession();
					in.close();
					break;
			}
		}
	}
}