package csku.mockitodemo.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BankCustomerTest {

	private Bank bank;
	private Customer cust;

	@BeforeEach
	void setup() {
		bank = new Bank("MyBank");
		cust = new Customer(1, 123, "Kwan");
		bank.addCustomer(cust);
	}

	@Test
	void testFindCustomer() {
		Customer found = bank.findCustomerById(1);
		assertNotNull(found);
		assertSame(cust, found);
	}

	@Test
	void testAddAnotherCustomerStateBased() {
		Customer anotherCust = new Customer(2, 456, "Noon");
		bank.addCustomer(anotherCust);

		Map<Integer, Customer> customers = bank.getCustomers();
		assertTrue(customers.containsValue(anotherCust));
	}

	@Test
	void testAddAnotherCustomer() {
		Customer anotherCust = new Customer(2, 456, "Noon");
		bank.addCustomer(anotherCust);

		Customer found = bank.findCustomerById(2);
		assertNotNull(found);
		assertSame(anotherCust, found);
	}

	@Test
	void testAddDuplicatedCustomer() {
		Customer dupCust = new Customer(1, 123, "Kwan");
		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> {
					bank.addCustomer(dupCust);
				});
		assertEquals("Cannot add duplicated customer",
				exception.getMessage());
	}

	@Test
	void testValidateCustomerValid() {
		assertTrue(bank.validateCustomer(1, 123));
	}

	@Test
	void testValidateCustomerNotValid() {
		assertFalse(bank.validateCustomer(1, 999));
	}
}
