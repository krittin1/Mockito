package csku.mockitodemo.atm;

public class Customer {
    private int id;
    private int pin;
    private String name;
    private BankAccount account;

    public Customer() {}
    public Customer(int id, int pin, String name) {
        this(id, pin, name, new BankAccount());
    }

    public Customer(int id, int pin, String name, BankAccount account) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean match(int pin) {
        return this.pin == pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
}
