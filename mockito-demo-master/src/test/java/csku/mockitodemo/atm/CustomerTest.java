package csku.mockitodemo.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer cust;

    @BeforeEach
    void setup() {
        cust = new Customer(1, 123, "Kwan");
    }

    @Test
    void testGetId() {
        assertEquals(1, cust.getId());
    }

    @Test
    void testGetName() {
        assertEquals("Kwan", cust.getName());
    }

    @Test
    void testSetName() {
        cust.setName("Noon");
        assertEquals("Noon", cust.getName());
    }

    @Test
    void testPinMatch() {
        assertTrue(cust.match(123));
    }

    @Test
    void testPinNotMatch() {
        assertFalse(cust.match(999));
    }
}
