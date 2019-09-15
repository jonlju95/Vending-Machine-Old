package se.ec.jonatan.third_app;

import java.util.*;

public class VendingMachineMain {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		VendingMachineClass machine = new VendingMachineClass();
		Scanner in = new Scanner(System.in);
		int option;
		System.out.println("Welcome! ");
		while(machine.keepBuying) {
			System.out.print("Choose an option: \n1: Add money \n2: Select an item to buy"
								+ "\n3: Examine an item without buying \n4: Examine all products in the machine "
								+ "\n5: End purchase \nSelection: ");
			option = Integer.parseInt(in.nextLine());
			switch (option) {
				case 1: 
					System.out.println("\nAdd one of the following values: " + Arrays.toString(machine.insertableValues));
					System.out.print("Amount: ");
					int insertedValue = Integer.parseInt(in.nextLine());
					machine.addCurrency(insertedValue);
					break;
				case 2:
					System.out.println();
					for(int i=0; i<machine.products.length; i++) {
						System.out.println(i+1 + ": " + machine.products[i].name + ", " + machine.products[i].cost + " kr");
					}
					System.out.print("Selection: ");
					int item = Integer.parseInt(in.nextLine())-1;
					machine.request(item);
					break;
				case 3: 
					System.out.println("\n1: Soda \n2: Chips \n3: Chocolate ");
					System.out.print("Option: ");
					item = Integer.parseInt(in.nextLine())-1;
					System.out.println(machine.getDescription(item) + "\n");
					break;
				case 4:
					System.out.println();
					for(int i=0; i<machine.getProducts().length; i++) {
						System.out.println(machine.getProducts()[i]);
					}
					System.out.println();
					break;
				case 5: 
					System.out.println("\nThank you for your purchase! \nHere is your change: "
										+ machine.getBalance() + " kr returned!");
					machine.endSession();
					break;
			}
		}
		System.out.print("\nDo you want to use your purchased item(s)? "
				+ "\nType Y/y for yes. Press enter without typing anything to stop \nAnswer: ");
		String answer = in.nextLine();
		if(answer.equals("Y") || answer.equals("y")) {
				System.out.println("Which product do you want to use? \nType the corresponding number");
				int count = 1;
				for(int i=0; i<machine.boughtProducts.size(); i++) {
					if(machine.boughtProducts.get(i).equals(0)) {
						continue;
					}
					else {
						System.out.println(count + ": " + machine.boughtProducts.get(i).name);
					}
					count++;
				}
				System.out.print("Selection: ");
				option = Integer.parseInt(in.nextLine());
				System.out.println(machine.boughtProducts.get(option-1).use());
				in.close();
		}
		else {
			in.close();
			System.out.println("\nYou bought: ");
			for(int i=0; i<machine.boughtProducts.size(); i++) {
				System.out.println(machine.boughtProducts.get(i).name);
			}
		}
	}
}