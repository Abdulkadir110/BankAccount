package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BanksTest {
    @Test
    void test_that_all_banks_are_added_and_get_bank_at_index_2(){
        Banks banks = new Banks();
        banks.addAllBanks();
        assertEquals(BankCodes.AFRIBANK, banks.getBank(2));
    }
}
