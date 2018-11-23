package csku.mockitodemo.hr;

public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double rate) {
        salary = salary + (salary * rate);
    }

    @Override
    public String toString() {
        return "Employee [name: " + name +
                " id: " + id +
                " salary: " + salary + " ]";
    }
}
