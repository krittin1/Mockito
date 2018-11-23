package csku.mockitodemo.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankDataServiceTest {

    private Bank bank;

    @BeforeEach
    void setup() {
        bank = new Bank("MyBank", new DataServiceStub());
        bank.addAllCustomers();
    }

    @Test
    void testFindCustomerById() {
        Customer cust = bank.findCustomerById(1);
        assertEquals("Kwan", cust.getName());
    }

    private class DataServiceStub implements IDataService<Customer> {

        @Override
        public Iterator<Customer> getAllObjects() {
            ArrayList<Customer> list = new ArrayList<>();
            list.add(new Customer(1, 123, "Kwan"));
            list.add(new Customer(2, 456, "Noon"));
            return list.iterator();
        }
    }
}
