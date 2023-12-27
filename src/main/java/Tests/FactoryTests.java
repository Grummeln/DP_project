package Tests;



import Account_Package.AbstractFactory;
import Account_Package.Account;
import Account_Package.AccountEUR;
import Account_Package.AccountRON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactoryTests {

    @Test
    public void testCreateEURAccount() throws Exception {
        AbstractFactory factory = new AccountEUR.EURFactory();
        Account account = factory.createEURAccount("EUR123", 1000);
        assertTrue(account instanceof AccountEUR);
    }

    @Test
    public void testCreateRONAccount() throws Exception {
        AbstractFactory factory = new AccountRON.RONFactory();
        Account account = factory.createRONAccount("RON123", 1000);
        assertTrue(account instanceof AccountRON);
    }

}
