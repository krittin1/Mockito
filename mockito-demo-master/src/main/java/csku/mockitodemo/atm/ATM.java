package csku.mockitodemo.atm;

public class ATM {
    private Bank bank;
    private BankAccount currentAccount;
    private Customer currentCustomer;
    private int state;

    private static final int START = 1;
    private static final int TRANSACT = 2;

    public ATM(Bank bank) {
        this.bank = bank;
        this.state = START;
    }

    public void reset() {
        currentCustomer = null;
        currentAccount = null;
        state = START;
    }

    public void validateCustomer(int custId, int pin) throws InvalidAccountException {
        assert state == START;

        if (bank.validateCustomer(custId, pin)) {
            currentCustomer = bank.findCustomerById(custId);
            currentAccount = currentCustomer.getAccount();
            state = TRANSACT;
        } else {
            throw new InvalidAccountException("Id or Pin is incorrect.");
        }
    }

    public void withdraw(double value) {
        assert state == TRANSACT;
        currentAccount.withdraw(value);
    }

    public void deposit(double value) {
        assert state == TRANSACT;
        currentAccount.deposit(value);
    }

    public double getBalance() {
        assert state == TRANSACT;
        return currentAccount.getBalance();
    }

    public void transfer(int toCustId, double amount) {
        assert state == TRANSACT;

        Customer receivingCustomer = bank.findCustomerById(toCustId);
        BankAccount receivingAccount = receivingCustomer.getAccount();

        currentAccount.withdraw(amount);
        receivingAccount.deposit(amount);
    }

    protected int getState() {
        return state;
    }
}
