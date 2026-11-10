//import tdd.Bank;
//import tdd.BankCodes;
//
//void main() {
//    Scanner inputCollector = new Scanner(System.in);
//    Bank firstBank = new Bank(BankCodes.FIRSTBANK);
//
//    String welcomeMessage = "Welcome to FirstBank Self-service Electronic Machine";
//    String menuFunctions = """
//            [1] Create An Account
//            [2] Deposit
//            [3] Withdraw
//            [4] Transfer
//            [5] Check Balance
//            [0] Exit
//            """;
//    IO.println(welcomeMessage);
//    IO.println(menuFunctions);
//    IO.print("Enter your option: ");
//    String choice = inputCollector.nextLine();
//    int ownerAccountNumber;
//    while (!choice.equals("0")) {
//        switch (choice){
//            case "1" -> {
//                IO.print("Enter your preferably account name: ");
//                String accountName = inputCollector.nextLine();
//                IO.print("Enter your preferably transaction pin: ");
//                String ownerPin = inputCollector.nextLine();
//                try {
//                    ownerAccountNumber = firstBank.createAccount(accountName, ownerPin);
//                } catch (IllegalArgumentException e) {
//                    IO.println("Error: " + e.getMessage());
//                    break;
//                }
//                System.out.printf("your account Number is : %d\naccount created successfully >>>>>>>>>>>>>>%n", ownerAccountNumber);
//            }
//            case "2" -> {
//                IO.print("How much do you want to deposit: ");
//                String userAmount = inputCollector.nextLine();
//                IO.print("Enter the account number: ");
//                String givenAccountNumber = inputCollector.nextLine();
//                try {
//                    validateDigit(userAmount);
//                    int depositAmount = convertToNumbers(userAmount);
//                    validateDigit(givenAccountNumber);
//                    int accountNumber = convertToNumbers(givenAccountNumber);
//                    firstBank.deposit(accountNumber, depositAmount);
//                    IO.println("amount deposited successfully >>>>>>>>>>>>>>>>>>");
//                }catch (IllegalArgumentException e){
//                    IO.println("Error: " + e.getMessage());
//                }
//            }
//            case "3" -> {
//                IO.print("How much do you want to withdraw: ");
//                String userAmount = inputCollector.nextLine();
//                IO.print("Enter the account number: ");
//                String givenAccountNumber = inputCollector.nextLine();
//                IO.print("Enter the your pin: ");
//                String ownerPin = inputCollector.nextLine();
//                try {
//                    validateDigit(userAmount);
//                    int withdrawAmount = convertToNumbers(userAmount);
//                    validateDigit(givenAccountNumber);
//                    int accountNumber = convertToNumbers(givenAccountNumber);
//                    firstBank.withdraw(accountNumber, withdrawAmount, ownerPin);
//                    IO.println("amount withdrew successfully >>>>>>>>>>>>>>>>>>");
//                }catch (IllegalArgumentException e){
//                    IO.println("Error: " + e.getMessage());
//                }
//            }
//            case "4" -> {
//                IO.print("How much do you want to transfer: ");
//                String userAmount = inputCollector.nextLine();
//                IO.print("Enter the sender's account number: ");
//                String senderAccount = inputCollector.nextLine();
//                IO.print("Enter the receiver's account number: ");
//                String receiverAccount = inputCollector.nextLine();
//                IO.println("Please Enter your pin to confirm your identity: ");
//                String inputtedPin = inputCollector.nextLine();
//                try {
//                    validateDigit(userAmount);
//                    int transferAmount = convertToNumbers(userAmount);
//                    validateDigit(receiverAccount);
//                    int receiverAccountNumber = convertToNumbers(receiverAccount);
//                    validateDigit(senderAccount);
//                    int senderAccountNumber = convertToNumbers(senderAccount);
//                    firstBank.transfer(transferAmount, senderAccountNumber, receiverAccountNumber, inputtedPin);
//                    IO.println("amount transferred successfully >>>>>>>>>>>>>>>>>>");
//                }catch (IllegalArgumentException e){
//                    IO.println("Error: " + e.getMessage());
//                }
//            }
//            case "5" -> {
//                IO.print("Enter the account number: ");
//                String givenAccountNumber = inputCollector.nextLine();
//                IO.println("Please Enter your pin to confirm your identity: ");
//                String inputtedPin = inputCollector.nextLine();
//                try {
//                    validateDigit(givenAccountNumber);
//                    int accountNumber = convertToNumbers(givenAccountNumber);
//                    IO.println("Your Balance is : " + firstBank.checkBalance(accountNumber, inputtedPin));
//                }catch (IllegalArgumentException e){
//                    IO.println("Error: " + e.getMessage());
//                }
//            }
//            default -> IO.println("---Invalid option -> Please enter between 1- 5--");
//            }
//    IO.println(menuFunctions);
//    IO.print("Enter your option: ");
//    choice = inputCollector.nextLine();
//    }
//    IO.println("Thank you for your using our app, we hope to see you again rate it!!!");
//}
//private void validateDigit(String numbers){
//    for(int index = 0; index < numbers.length(); index++){
//        if(!Character.isDigit(numbers.charAt(index))) throw new IllegalArgumentException("Please enter only numbers");
//    }
//}
//private int convertToNumbers(String numbers){
//    return Integer.parseInt(numbers);
//}