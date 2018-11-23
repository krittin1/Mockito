package csku.mockitodemo.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


class ATMTestMock {

    @Mock private Bank stubBank;
    @Mock private Customer stubCustomer1;
    @Mock private Customer stubCustomer2;
    @Mock private BankAccount mockAccount1;
    @Mock private BankAccount mockAccount2;

    // CUT
    private ATM atm;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
        atm = new ATM(stubBank);
    }

    @Test
    void testTransfer() throws InvalidAccountException {
        int senderId = 1;
        int receiverId = 2;
        int senderPIN = 111;
        int amount = 200;

        when(stubBank.validateCustomer(senderId, senderPIN)).thenReturn(true);

        when(stubBank.findCustomerById(senderId)).thenReturn(stubCustomer1);
        when(stubCustomer1.getAccount()).thenReturn(mockAccount1);

        when(stubBank.findCustomerById(receiverId)).thenReturn(stubCustomer2);
        when(stubCustomer2.getAccount()).thenReturn(mockAccount2);

        atm.validateCustomer(senderId, senderPIN);
        atm.transfer(receiverId, amount);

        verify(mockAccount1).withdraw(amount);
        verify(mockAccount2).deposit(amount);
    }

}
