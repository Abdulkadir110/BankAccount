package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private Account myAccount;
    private final String correctPin = "1111";
    private final String wrongPin = "1121";
    @BeforeEach
    public void instantiateBeforeEach() {
       myAccount = new Account(correctPin);
    }
    @Test
    public void testThatIDeposit5kAndTheBalanceIs5k(){
        //Given
        assertEquals(0.0, myAccount.getBalance(correctPin));
        //When
        myAccount.deposit(5_000);
        //check
        assertEquals(5000, myAccount.getBalance(correctPin));
    }
    @Test
    public void testThatIDepositMinus5kAndBalanceRemainsTheSame(){
        //Given
        assertEquals(0.0, myAccount.getBalance(correctPin));
        //When
        try {
            myAccount.deposit(-5_000);
        }
        catch (IllegalArgumentException e ){
            //Nothing
        }
        //Check
        assertEquals(0.0, myAccount.getBalance(correctPin));
    }
    @Test
    public void testThatIWithdraw2kFrom5k_TheBalanceIs3k() {
        //Given
        assertEquals(0.0, myAccount.getBalance(correctPin));
        //When
        myAccount.deposit(5_000);
        assertEquals(5000, myAccount.getBalance(correctPin));
        myAccount.withdraw(2000,correctPin);
        assertEquals(3000, myAccount.getBalance(correctPin));
    }
    @Test
    public void testThatICantWithdrawNegativeAmount(){
        assertEquals(0.0, myAccount.getBalance(correctPin));
        myAccount.deposit(5_000);
        try {
            myAccount.withdraw(-2000,correctPin);
        }catch (IllegalArgumentException e){
            //Nothing
        }
        assertEquals(5000, myAccount.getBalance(correctPin));
    }
    @Test
    public void testThatICantWithdrawWithIncorrectPin(){
        assertEquals(0.0, myAccount.getBalance(correctPin));
        myAccount.deposit(5_000);
        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(2000,wrongPin));
        assertEquals(5000, myAccount.getBalance(correctPin));
    }
    @Test
    public void testToCheckBalanceWithIncorrectPin(){
        assertThrows(IllegalArgumentException.class,() -> myAccount.getBalance(wrongPin));
    }
}
