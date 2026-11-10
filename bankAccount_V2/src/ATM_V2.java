package tdd;

import java.util.Scanner;

public class ATM_V2 {
    private static Banks banks = new Banks();

    public static void main(String[] args) {
        gotoMainMenu();
    }

    private static void gotoMainMenu(){
        banks.addAllBanks();
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

    private static void createAccount(){
        print("""
            ====================================
                        SELECT A BANK
            ====================================
            [1] ACCESS BANK
            [2] AFRI-BANK
            [3] CITIBANK
            [4] DIAMOND BANK
            [5] ECO BANK
            [6] EQUITORIAL TRUST BANK
            [7] FIRST BANK
            [8] FCMB
            [9] FIDELITY BANK
            [10] FIN-BANK
            [11] GUARANTY TRUST BANK
            [12] INTERCONTINENTAL BANK
            [13] OCEANIC BANK
            [14] BANK PHB
            [15] SKYE BANK
            [16] SPRING BANK
            [17] STANBIC-IBTC
            [18] STANDARD CHARTERED BANK
            [19] STERLING BANK
            [20] UNITED BANK FOR AFRICA
            [21] UNION BANK
            [22] WEMA BANK
            [23] ZENITH BANK
            [24] UNITY BANK
            ========================================
            ========================================
            """);
        int userChoice = convertToNumbers(input("Enter between 1 to 24: "));
        try{
            String accountName = input("Enter your preferred account name: ");
            String pin = input("Enter your pin: ");
            BankCodes code = banks.getBank(userChoice);
            Bank bank = new Bank(code);
            String accountNumber = bank.createAccount(accountName, pin);

            print("Your account number is : " + accountNumber +  "\nAccount created Successfully>>>>>>");
        }catch (IllegalArgumentException ex){
            print(ex.getMessage());
        }
        finally{
            gotoMainMenu();
        }
    }

    private static void deposit() {
        try {
            int userChoice = convertToNumbers(input("Enter Bank Choice (1 to 24): "));
            String accountNumber = input("Enter account number: ");
            double amount = Double.parseDouble(input("Enter amount to deposit: "));

            BankCodes code = banks.getBank(userChoice);
            Bank bank = new Bank(code);
            bank.deposit(accountNumber, amount);

            print("Deposit successful >>>>>>");
        } catch (IllegalArgumentException ex) {
            print(ex.getMessage());
        } finally {
            gotoMainMenu();
        }
    }

    private static void withdraw() {
        try {
            int userChoice = convertToNumbers(input("Enter Bank Choice (1 to 24): "));
            String accountNumber = input("Enter account number: ");
            double amount = Double.parseDouble(input("Enter amount to withdraw: "));
            String pin = input("Enter your pin: ");

            BankCodes code = banks.getBank(userChoice);
            Bank bank = new Bank(code);
            bank.withdraw(accountNumber, amount, pin);

            print("Withdrawal successful >>>>>>");
        } catch (IllegalArgumentException ex) {
            print(ex.getMessage());
        } finally {
            gotoMainMenu();
        }
    }

    private static void transfer() {
        try {
            int senderBankChoice = convertToNumbers(input("Enter Sender Bank Choice (1 to 24): "));
            String senderAccountNumber = input("Enter sender account number: ");

            int receiverBankChoice = convertToNumbers(input("Enter Receiver Bank Choice (1 to 24): "));
            String receiverAccountNumber = input("Enter receiver account number: ");

            double amount = Double.parseDouble(input("Enter amount to transfer: "));
            String pin = input("Enter your pin: ");

            Bank senderBank = new Bank(banks.getBank(senderBankChoice));
            Bank receiverBank = new Bank(banks.getBank(receiverBankChoice));

            senderBank.transfer(amount, senderAccountNumber, receiverAccountNumber, pin);
            if (senderBankChoice != receiverBankChoice) {
                receiverBank.deposit(receiverAccountNumber, amount);
            }

            print("Transfer successful >>>>>>");
        } catch (IllegalArgumentException ex) {
            print(ex.getMessage());
        } finally {
            gotoMainMenu();
        }
    }

    private static void checkBalance() {
        try {
            int userChoice = convertToNumbers(input("Enter Bank Choice (1 to 24): "));
            String accountNumber = input("Enter account number: ");
            String pin = input("Enter your pin: ");

            BankCodes code = banks.getBank(userChoice);
            Bank bank = new Bank(code);
            double balance = bank.checkBalance(accountNumber, pin);

            print("Your current balance is: " + balance);
        } catch (IllegalArgumentException ex) {
            print(ex.getMessage());
        } finally {
            gotoMainMenu();
        }
    }

    private static void exit() {
        print("Thank you for banking with us.");
        System.exit(0);
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