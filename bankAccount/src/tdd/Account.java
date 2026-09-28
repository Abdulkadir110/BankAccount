package tdd;

public class Account {
    private double balance;
    private String pin;

    public double getBalance(String pin) {
        if(!pin.equals(this.pin)) throw new IllegalArgumentException("Incorrect Pin");
        return balance;
    }
    public void deposit(double amount) {
        if(amount > 0)balance += amount;
    }
    public void withdraw(double amount, String pin) {
        if(amount > 0 && amount <= balance && pin.equals(this.pin)) {
            balance -= amount;
        }
        else if (!pin.equals(this.pin)){
            throw new IllegalArgumentException("Incorrect Pin");
        }
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public void updatePin(String oldPin, String newPin){
        if(oldPin.equals(this.pin))this.pin = newPin;
        else{
            throw new IllegalArgumentException("Incorrect Pin");
        }
    }
}