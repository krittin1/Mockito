package csku.mockitodemo.atm;

public class Application {

    public static void main(String[] args) {
        Bank bank = new Bank("myBank");
        ATM atm = new ATM(bank);
    }

}
