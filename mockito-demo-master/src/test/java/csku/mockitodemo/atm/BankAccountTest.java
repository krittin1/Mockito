package csku.mockitodemo.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    private BankAccount act;

    @BeforeEach
    void setup() {
        act = new BankAccount(1000);
    }

    @Test
    void testDeposit() {
        act.deposit(200);
        assertEquals(1200, act.getBalance());
    }

    @Test
    void testWithdrawLessThanBalance() {
        act.withdraw(100);
        assertEquals(900, act.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> { act.withdraw(100000); });
        assertEquals("Withdraw more than balance",
                exception.getMessage());
    }
}
