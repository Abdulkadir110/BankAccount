package tdd;

public class Account {
    private double balance;
    private String pin;
    private String accountNumber;

    public Account(String defaultPin){
        validateLength(defaultPin);
        this.pin = defaultPin;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(String userPin) {
        validate(userPin);
        return balance;
    }
    public void deposit(double amount) {
        validate(amount);
        balance += amount;
    }
    public void withdraw(double amount, String userPin) {
        validate(userPin);
        validate(amount);
        boolean isValidTransaction = amount <= balance;
        if(isValidTransaction)balance -= amount;
    }
    private void validateLength(String pin){
        if(pin.length() != 4) throw new IllegalArgumentException("Please put a 4 digits Pin");
    }
    private void validate(String userPin){
        if(!pin.equals(userPin)) throw new IllegalArgumentException("Invalid pin");
    }
    private void validate(double amount){
        if(amount < 0) throw new IllegalArgumentException("Invalid amount");
    }
}