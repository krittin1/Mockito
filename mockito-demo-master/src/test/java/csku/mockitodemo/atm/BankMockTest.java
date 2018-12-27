package csku.mockitodemo.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BankMockTest {
    @Mock private Customer customer1;
    @Mock private Customer customer2;

    // class under test (CUT)
    private Bank bank;



    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
        bank = new Bank("SCB");
    }

    @Test
    void validateCustomerTest(){
        int customerId1 = 100, customerPin1 = 111;
        int customerId2 = 200, customerPin2 = 222;
        when(customer1.getId()).thenReturn(customerId1);
        when(customer1.getPin()).thenReturn(customerPin1);
        when(customer2.getId()).thenReturn(customerId2);
        when(customer2.getPin()).thenReturn(customerPin2);
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.validateCustomer(customerId1, customerPin1);
        bank.validateCustomer(customerId2, customerPin2);
        verify(customer1).match(customerPin1);
        verify(customer2).match(customerPin2);
    }
}
