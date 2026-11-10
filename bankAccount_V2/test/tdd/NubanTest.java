package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NubanTest {
    private Nuban nuban;
    @BeforeEach
    void startWith(){
        nuban = new Nuban();
    }
    @Test
    void test_AccessBank_AccountNumberGenerated_withValidLength(){
        String generatedAccountNumber = nuban.createAccountNumber(BankCodes.ACCESSBANK);
        assertEquals(13, generatedAccountNumber.length());
    }
    @Test
    void test_FirstBank_AccountNumberGenerated_withValidLength(){
        String generatedAccountNumber = nuban.createAccountNumber(BankCodes.FIRSTBANK);
        assertEquals(13, generatedAccountNumber.length());
        assertTrue(nuban.isValid(generatedAccountNumber));
    }
    @Test
    void test_AccountNumber_Is_AValid_AccountNumber(){
        assertTrue(nuban.isValid("0110000014579"));
        assertTrue(nuban.isValid("0110000000220"));
        assertFalse(nuban.isValid("0110000014578"));
        assertFalse(nuban.isValid("9990000014579"));
        assertFalse(nuban.isValid(null));
    }
}