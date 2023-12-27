package Tests;
import Account_Package.AbstractFactory;
import Account_Package.Account;
import Account_Package.AccountEUR;
import Account_Package.AccountRON;
import Account_Package.Commander.*;
import Account_Package.Operations.Operations;
import Bank_Package.Bank;
import Client_Package.Client;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class CommandTests {
    AbstractFactory EURFactory = new AccountEUR.EURFactory();
    AbstractFactory RONFactory = new AccountRON.RONFactory();
    LinkedList<Client> clients = new LinkedList<>();
    Bank bcr = new Bank(clients, "BCR");
    @Test
    void blockAccountTest() throws Exception {
        Manager om = new Manager();
        Account commandAcc = RONFactory.createRONAccount("commandAcc1", 100);
        assertNotNull(commandAcc);
        Operations o1 = new block_account(commandAcc);
        Operations o2 = new unblock_account(commandAcc);
        assertFalse(commandAcc.is_account_blocked());
        om.executeOp(o1);
        assertTrue(commandAcc.is_account_blocked());
        om.undo();
        assertFalse(commandAcc.is_account_blocked());
        om.executeOp(o2);
        assertFalse(commandAcc.is_account_blocked());
        om.undo();
        assertFalse(commandAcc.is_account_blocked());
    }

    @Test
    void retrieveDeposeTest() throws Exception {
        Manager om = new Manager();
        Account commandAcc = RONFactory.createRONAccount( "commandAcc2", 100);
        Operations o1 = new depose(commandAcc, 30);
        Operations o2 = new retrieve(commandAcc, 20);
        assertNotNull(commandAcc);
        assertEquals(commandAcc.getTotalAmount(), 103);
        om.executeOp(o1);
        om.executeOp(o1);
        om.executeOp(o2);
        om.executeOp(o1);
        assertEquals(commandAcc.getTotalAmount(), 175.1);
        om.undo();
        om.undo();
        assertEquals(commandAcc.getTotalAmount(), 164.8);
        om.redo();
        assertEquals(commandAcc.getTotalAmount(), 144.2);
    }
}
