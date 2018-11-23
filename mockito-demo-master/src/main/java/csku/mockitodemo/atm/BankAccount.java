package csku.mockitodemo.atm;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this(0);
    }

    public BankAccount(double initial) {
        balance = initial;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Withdraw more than balance");
        }
        balance -= amount;
    }
}
