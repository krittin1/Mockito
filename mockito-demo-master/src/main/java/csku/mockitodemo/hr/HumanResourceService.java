package csku.mockitodemo.hr;

import java.util.ArrayList;
import java.util.List;

public class HumanResourceService {

    private List<Employee> employeeList;

    public HumanResourceService() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void raiseSalaryAll(double rate) {
        for (Employee employee : employeeList) {
            employee.raiseSalary(rate);
        }
    }

}
