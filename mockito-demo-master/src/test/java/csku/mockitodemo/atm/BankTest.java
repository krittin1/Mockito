package csku.mockitodemo.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class BankTest {

	private Bank bank;
	private FakeCustomer cust;

	@BeforeEach
	void setup() {
		bank = new Bank("MyBank");
		cust = new FakeCustomer(1, 123, "Kwan");
		bank.addCustomer(cust);
	}

	@Test
	void testFindCustomer() {
		Customer found = bank.findCustomerById(1);
		assertNotNull(found);
		assertSame(cust, found);
	}

	class FakeCustomer extends Customer {

        FakeCustomer(int id, int pin, String name) {
            super(id, pin, name);
        }

        // override complicated / slow method
        public void complexMethod() {
            // complex code
        }
    }
}
