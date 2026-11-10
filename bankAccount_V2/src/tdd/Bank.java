package tdd;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private BankCodes bankCodes;

    public Bank(BankCodes bankCodes) {
        this.bankCodes = bankCodes;
    }

    public BankCodes getBankCodes() {
        return bankCodes;
    }

    private String generateAccountNumber() {
        Nuban nuban = new Nuban();
        return nuban.createAccountNumber(bankCodes);
    }
    public String createAccount(String accountName, String userPin) {
        String accountNumber = generateAccountNumber();
        Account account = new Account(userPin);
        account.setAccountNumber(accountNumber);
        accounts.add(account);
        return accountNumber;
    }
    public int numberOfCustomers(){
        return accounts.size();
    }

    public void deposit(String accountNumber, double amount) {
        Account foundAccount = findAccount(accountNumber);
        foundAccount.deposit(amount);
    }
    public double checkBalance(String accountNumber, String userPin){
        Account foundAccount = findAccount(accountNumber);
        validateFoundAccount(foundAccount);
        return foundAccount.getBalance(userPin);
    }
    public void withdraw(String accountNumber, double amount, String pin){
        Account foundAccount = findAccount(accountNumber);
        validateFoundAccount(foundAccount);
        validateTransaction(accountNumber, amount, pin);
        foundAccount.withdraw(amount, pin);
    }
    private Account findAccount(String accountNumber) {
        validateAccountNumber(accountNumber);
        for(Account account : accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }
    public void transfer(double amount, String senderAccountNumber, String receiverAccountNumber, String senderPin) {
        validateAccountNumber(senderAccountNumber);
        validateAccountNumber(receiverAccountNumber);
        withdraw(senderAccountNumber, amount, senderPin);
        deposit(receiverAccountNumber, amount);
    }
    private void validateTransaction(String accountNumber, double amount, String userPin){
        Account foundAccount = findAccount(accountNumber);
        validateFoundAccount(foundAccount);
        if(foundAccount.getBalance(userPin) < amount ) throw new IllegalArgumentException("Insufficient balance");
    }
    private void validateAccountNumber(String accountNumber){
        Nuban nuban = new Nuban();
        if(!nuban.isValid(accountNumber)) throw new IllegalArgumentException("Invalid Account number");
    }
    private void validateFoundAccount(Account account){
        if(account == null) throw new IllegalArgumentException("Account hasn't been created");
    }
}
