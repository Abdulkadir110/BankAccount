import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private Account myAccount;

    @BeforeEach
    public void instantiateBeforeEach() {
       myAccount = new Account();
    }
    @Test
    public void testThatIDeposit5kAndTheBalanceIs5k(){
        //Given
        myAccount.setPin("1111");
        assertEquals(0.0, myAccount.getBalance("1111"));
        //When
        myAccount.deposit(5_000);
        //check
        assertEquals(5000, myAccount.getBalance("1111"));
    }
    @Test
    public void testThatIDepositMinus5kAndBalanceRemainsTheSame(){
        //Given
        myAccount.setPin("1111");
        assertEquals(0.0, myAccount.getBalance("1111"));
        //When
        myAccount.deposit(-5_000);
        //Check
        assertEquals(0.0, myAccount.getBalance("1111"));
    }
    @Test
    public void testThatIWithdraw2kFrom5k_TheBalanceIs3k() {
        //Given
        myAccount.setPin("1111");
        assertEquals(0.0, myAccount.getBalance("1111"));
        //When
        myAccount.deposit(5_000);
        assertEquals(5000, myAccount.getBalance("1111"));
        myAccount.withdraw(2000,"1111");
        assertEquals(3000, myAccount.getBalance("1111"));
    }
    @Test
    public void testThatICantWithdrawNegativeAmount(){
        myAccount.setPin("1111");
        assertEquals(0.0, myAccount.getBalance("1111"));
        myAccount.deposit(5_000);
        myAccount.withdraw(-2000,"1111");
        assertEquals(5000, myAccount.getBalance("1111"));
    }
    @Test
    public void testThatICantWithdrawWithIncorrectPin(){
        myAccount.setPin("1111");
        assertEquals(0.0, myAccount.getBalance("1111"));
        myAccount.deposit(5_000);
        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(2000,"1121"));
        assertEquals(5000, myAccount.getBalance("1111"));
    }
    @Test
    public void testToCheckBalanceWithIncorrectPin(){
        myAccount.setPin("1111");
        assertThrows(IllegalArgumentException.class,() -> myAccount.getBalance("9028"));
    }
    @Test
    public void testThatAccountPinWasUpdated(){
        myAccount.setPin("1121");
        assertEquals(0.0, myAccount.getBalance("1121"));
        myAccount.deposit(5_000);
        myAccount.withdraw(2000,"1121");
        assertEquals(3000, myAccount.getBalance("1121"));
        myAccount.updatePin("1121", "1111");
        myAccount.withdraw(2000,"1111");
        assertEquals(1000, myAccount.getBalance("1111"));
        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(500,"1121"));
        assertEquals(1000, myAccount.getBalance("1111"));
    }
    @Test
    public void testThatAccountPinWasNotUpdated(){
        myAccount.setPin("1121");
        assertEquals(0.0, myAccount.getBalance("1121"));
        myAccount.deposit(5_000);
        assertThrows(IllegalArgumentException.class, () -> myAccount.updatePin("2345", "1234"));
        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(4000, "1234"));
        assertEquals(5000, myAccount.getBalance("1121"));

    }
}
