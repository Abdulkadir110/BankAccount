package tdd;

import java.util.concurrent.ThreadLocalRandom;

public class Nuban {
    private int[] VERIFIERS = {3,7,3,3,7,3,3,7,3,3,7,3};

    public String createAccountNumber(BankCodes bankCode){
        if(bankCode.getBankCode() == null) return null;
        String serialNumber = String.format("%09d", ThreadLocalRandom.current().nextInt(100_000, 1_000_000));
        String base = bankCode.getBankCode() + serialNumber;
        return base + getCheckDigit(base);
    }
    public boolean isValid(String accountNumber){
        if(accountNumber == null) return false;
        if(!isValidLength(accountNumber)) return false;
        return isEquals(accountNumber);
    }
    private boolean isEquals(String accountNumber){
        int lastDigit = Character.getNumericValue(accountNumber.charAt(12));
        int checkDigit = getCheckDigit(accountNumber);
        return lastDigit == checkDigit;
    }
    private boolean isValidBankCode(String accountNumber){
        String firstThreeDigit = accountNumber.substring(0,3);
        for(BankCodes code : BankCodes.values()){
            if(code.getBankCode().equals(firstThreeDigit)){
                return true;
            }
        }
        return false;
    }
    private boolean isValidLength(String accountNumber){
        return accountNumber.length() == 13;
    }
    private int getSumOfEach(String accountNumber){
        if(!isValidBankCode(accountNumber))return -1;
        int sum = 0;
        for(int index = 0; index < VERIFIERS.length; index++){
            sum += (Character.getNumericValue(accountNumber.charAt(index)) * VERIFIERS[index]);
        }
        return sum;
    }
    private int getCheckDigit(String accountNumber){
        int result = getSumOfEach(accountNumber);
        return (10 - (result % 10)) % 10;
    }
}