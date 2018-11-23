package csku.mockitodemo.hr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeUnitTest {

    @Test
    void testRaiseSalary() {
        Employee emp1 = new Employee("john",1,1000);
        emp1.raiseSalary(0.1);
        assertEquals(1100,emp1.getSalary(),0.001);
    }


}
