package se.ec.jonatan.third_app;

import java.util.Scanner;

public class VendingMachineMain {
	public static void main(String[] args) {
		ActualVendingMachine test = new ActualVendingMachine();
		Scanner in = new Scanner(System.in);
		int option;
		System.out.println("Welcome! ");
		while(test.keepBuying) {
			System.out.println("Choose an option: \n1: Add money");
			option = Integer.parseInt(in.nextLine());
			switch (option) {
				case 1: 
					System.out.print("Amount: ");
					test.addCurrency(Integer.parseInt(in.nextLine()));
					System.out.println("\n----- " + test.getBalance() + " kr inserted -----\n");
					break;
				default: 
					System.out.println("Thank you for your purchase! Here is your change: "
							+ test.getBalance() + " kr returned!");
					test.endSession();
					break;
			}
			
			
			
			
			//System.out.println(test.getDescription(Integer.parseInt(in.nextLine())));
			/*for(int i=0; i<test.getProducts().length; i++) {
				System.out.println(test.getDescription(i));
			}
			
			System.out.println("What do you want to buy?");
			test.request(Integer.parseInt(in.nextLine()));
		*/
		}
	}
}