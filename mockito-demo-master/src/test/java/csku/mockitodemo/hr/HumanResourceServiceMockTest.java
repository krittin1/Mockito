package csku.mockitodemo.hr;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.mockito.Mockito.verify;

public class HumanResourceServiceMockTest {
    @Mock private Employee employee1;
    @Mock private Employee employee2;

    // class under test (CUT)
    private HumanResourceService humanResorce;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
        humanResorce = new HumanResourceService();
    }

    @Test
    void raiseSalaryAllTest() {
       double rate = 0.1;
       humanResorce.addEmployee(employee1);
       humanResorce.addEmployee(employee2);
       humanResorce.raiseSalaryAll(rate);
       verify(employee1).raiseSalary(rate);
       verify(employee2).raiseSalary(rate);
    }






}
