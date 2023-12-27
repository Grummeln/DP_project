package Account_Package.Decorators;

import Account_Package.Account;
import Account_Package.AccountDecorator;

public class EconomyAccount extends AccountDecorator {
    public EconomyAccount(Account acc){
        super(acc);
    }

    @Override
    public void transfer(Account c, double s) throws Exception {

    }

    @Override
    public String toString(){
        return acc.toString() + "\n\tThis is an economy account.";
    }

    @Override
    public void execute() throws Exception {

    }

    @Override
    public void undo() throws Exception {

    }

    @Override
    public void redo() throws Exception {

    }

    @Override
    public double getInterest() {
        return 0;
    }
}
