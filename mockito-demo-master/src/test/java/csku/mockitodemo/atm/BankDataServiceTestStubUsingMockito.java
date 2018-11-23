package csku.mockitodemo.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class BankDataServiceTestStubUsingMockito {

    @Mock private IDataService stubDataService;
    private Bank bank;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
        bank = new Bank("MyBank", stubDataService);
    }
    @Test
    void testFindCustomerById() {
        // stubbing
        ArrayList<Customer> list = new ArrayList<>();
        list.add(new Customer(1, 123, "Kwan"));
        list.add(new Customer(2, 456, "Noon"));
        when(stubDataService.getAllObjects()).thenReturn(list.iterator());

        // calling method to be tested
        bank.addAllCustomers();

        // checking result values
        Customer cust = bank.findCustomerById(1);
        assertEquals("Kwan", cust.getName());

        cust = bank.findCustomerById(2);
        assertEquals("Noon", cust.getName());
    }
}
