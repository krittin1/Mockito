package csku.mockitodemo.atm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BankFile {
    private String bankName;

    private Map<Integer, Customer> customers;

    public BankFile(String name) {
        this.bankName = name;
        this.customers = new HashMap<>();
    }
    public void addAllCustomers() {
        try {
            FileReader file = new FileReader("customers.csv");
            BufferedReader in = new BufferedReader(file);

            String line;
            while ((line = in.readLine()) != null) {
                String[] data = line.trim().split(",");
                int id = Integer.parseInt(data[0]);
                int pin = Integer.parseInt(data[1]);
                String name = data[2];
                Customer cust = new Customer(id, pin, name);
                addCustomer(cust);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File customers.csv cannot be found");
        } catch (IOException e) {
            System.err.println("Error reading file customers.csv");
            e.printStackTrace();
        }
    }


    public void addCustomer(Customer c) {
        if (c == null)
            throw new IllegalArgumentException("Customer must not be null");

        if (customers.containsKey(c.getId()))
            throw new IllegalArgumentException("Cannot add duplicate customer");

        customers.put(c.getId(), c);
    }
    public Customer findCustomerById(int custId) {
        return customers.get(custId);
    }

    public final boolean validateCustomer(int custId, int pin) {
        Customer customer = findCustomerById(custId);
        if (customer != null && customer.match(pin)) {
            return true;
        }
        return false;
    }
}
