package tdd;


import java.util.ArrayList;
import java.util.List;

public class Banks {
    private List<Bank> banks = new ArrayList<>();

    public void addBank(BankCodes code) {
        banks.add(new Bank(code));
    }

    public void addAllBanks() {
        for (BankCodes code : BankCodes.values()){
            addBank(code);
        }
    }
    public BankCodes getBank(int index){
        validate(index);
        return banks.get(index - 1).getBankCodes();
    }
    private void validate(int index){
        if(index < 1 || index > 24) throw new IllegalArgumentException("Invalid bank type");
    }
}
