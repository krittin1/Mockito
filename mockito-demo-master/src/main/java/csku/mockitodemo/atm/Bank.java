package csku.mockitodemo.atm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bank {
    private String bankName;

    private Map<Integer, Customer> customers;
    private IDataService dataService;

    public Bank(String name) {
        this(name, new CustomerFileDataService());
    }
    protected Bank(String name, IDataService dataService) {
        this.bankName = name;
        this.customers = new HashMap<>();
        this.dataService = dataService;
    }
    public void setDataService(IDataService dataService) {
        this.dataService = dataService;
    }

    protected Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public void addAllCustomers() {
        Iterator<Customer> itr = dataService.getAllObjects();
        while (itr.hasNext()) {
            addCustomer(itr.next());
        }
    }

    public void addCustomer(Customer c) {
        if (c == null)
            throw new IllegalArgumentException("Customer must not be null");

        if (customers.containsKey(c.getId()))
            throw new IllegalArgumentException("Cannot add duplicated customer");

        customers.put(c.getId(), c);
    }
    public Customer findCustomerById(int custId) {
        return customers.get(custId);
    }

    public boolean validateCustomer(int custId, int pin) {
        Customer customer = findCustomerById(custId);
        if (customer != null && customer.match(pin)) {
            return true;
        }
        return false;
    }

}
