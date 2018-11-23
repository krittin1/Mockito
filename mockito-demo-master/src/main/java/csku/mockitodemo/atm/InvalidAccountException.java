package csku.mockitodemo.atm;

public class InvalidAccountException extends Exception {
    public InvalidAccountException() {}
    public InvalidAccountException(String reason) {
        super(reason);
    }
}
