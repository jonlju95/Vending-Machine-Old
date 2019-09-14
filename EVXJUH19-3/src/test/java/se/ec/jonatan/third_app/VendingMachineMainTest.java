package se.ec.jonatan.third_app;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendingMachineMainTest extends VendingMachineMain{
	ActualVendingMachine testMachine;
	VendingMachineMain testMainMachine;
	
	@BeforeEach
	void setUp() {
		testMachine = new ActualVendingMachine();
	}
	
	@Test
	void testMain() {
		System.out.println("----- TEST START -----\n");
		String[] args = new String[] {};
		VendingMachineMain.main(args);
	}
	
	@Test
	void testAddCurrency() {
		testMachine.addCurrency(500);
		assertEquals(500, testMachine.getBalance());
		testMachine.addCurrency(45);
	}

	@Test
	void testGetBalance() {
		testAddCurrency();
		assertEquals(500, testMachine.getBalance());
	}

	@Test
	void testRequest() {
		testMachine.request(1);
		testMachine.addCurrency(500);
		testMachine.request(1);
	}

	@Test
	void testEndSession() {
		testMachine.addCurrency(100);
		testMachine.request(1);
		assertEquals(40, testMachine.endSession());
	}

	@Test
	void testGetDescription() {
		testMachine.getDescription(0);
	}

	@Test
	void testGetProducts() {
		testMachine.getProducts();
	}
}
