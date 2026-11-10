import tdd.Bank;
import tdd.BankCodes;

import java.util.Scanner;

public class ATM {
    void main (){
        gotoMainMenu();
    }

    private static Bank firstBank = new Bank(BankCodes.FIRSTBANK);

    private static void gotoMainMenu(){
        print("""
            [1] Create An Account
            [2] Deposit
            [3] Withdraw
            [4] Transfer
            [5] Check Balance
            [6] Exit
            """);
        char userChoice = input("Enter your option: ").charAt(0);
        switch (userChoice){
            case '1' -> createAccount();
            case '2' -> deposit();
            case '3' -> withdraw();
            case '4' -> transfer();
            case '5' -> checkBalance();
            case '6' -> exit();
            default -> print("Invalid choice");
        }
    }
    private static void exit(){
        print("Thank you for using my mobile Bank application");
    }
    private static void checkBalance() {
        try{
            String accountNumber = input("Enter your account number: ");
            String pin = input("Please Enter your pin to confirm your identity: ");
            print("Your balance is " + firstBank.checkBalance(accountNumber,pin));
        }catch (IllegalArgumentException ex){
            print(ex.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void transfer() {
        try{
            String senderAccountNumber = input("Enter the sender's account number: ");
            String receiverAccountNumber = input("Enter the receiver's account number: ");
            double amount = convertToNumbers(input("How much do you want to transfer: "));
            String senderPin = input("Please Enter your pin to confirm your identity: ");
            firstBank.transfer(amount,senderAccountNumber,receiverAccountNumber,senderPin);
            print("transferred successfully>>>>>>>>>>>>>>>>>>>>>");
        }catch (IllegalArgumentException ex){
            print(ex.getMessage());
        }
        finally {
            gotoMainMenu();
        }
    }

    private static void withdraw() {
        try{
            double amount = convertToNumbers(input("How much do you want to withdraw: "));
            String accountNumber = input("Enter the account number: ");
            String accountPin = input("Enter your pin");
            firstBank.withdraw(accountNumber, amount, accountPin);
            print(amount + " withdrew successfully >>>>>>>>>>>>>\nYour new balance is : " + firstBank.checkBalance(accountNumber, accountPin));
        }catch (IllegalArgumentException ex){
            print(ex.getMessage());
        }finally {
            gotoMainMenu();
        }
    }

    private static void deposit() {
        try{
            double amount = convertToNumbers(input("How much do you want to deposit: "));
            String accountNumber = input("Enter the account number: ");
            firstBank.deposit(accountNumber, amount);
            print(amount + " deposited successfully >>>>>>>>>>>>>");
        }catch (IllegalArgumentException ex){
            print(ex.getMessage());
        }finally {
            gotoMainMenu();
        }
    }

    private static void createAccount() {
        try{
            String accountName = input("Enter your preferably account name: ");
            String pin = input("Enter your pin");
            String accountNumber = firstBank.createAccount(accountName, pin);
            print("Your account number is : " + accountNumber +  "\nAccount created Successfully>>>>>>");
        }catch (IllegalArgumentException ex){
            print(ex.getMessage());
        }
        finally{
            gotoMainMenu();
        }
    }

    private static void print(String message){
        System.out.println(message);
    }
    private static String input(String message){
        Scanner input = new Scanner(System.in);
        print(message);
        return input.nextLine();
    }
    private static int convertToNumbers(String numbers){
        validate(numbers);
        return Integer.parseInt(numbers);
    }
    private static String validate(String numbers){
        for(int index = 0; index < numbers.length(); index++){
            if(!Character.isDigit(numbers.charAt(index))) throw new IllegalArgumentException("Please enter only numbers");
        }
        return numbers;
    }
}
