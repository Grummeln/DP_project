package Account_Package.Commander;

import Account_Package.Account;
import Account_Package.Operations.Operations;

public class retrieve implements Operations {
    Account mAcc;
    double mSum;

    public retrieve(Account acc, double sum){
        mAcc = acc;
        mSum = sum;
    }

    @Override
    public void execute() throws Exception {
        mAcc.retrieve(mSum);
    }

    @Override
    public void undo() throws Exception {
        mAcc.depose(mSum);
    }

    @Override
    public void redo() throws Exception {
        mAcc.retrieve(mSum);
    }

    @Override
    public double getTotalAmount() {
        return 0;
    }

    @Override
    public double getInterest() {
        return 0;
    }

    @Override
    public void depose(double amount) throws Exception {

    }

    @Override
    public void retrieve(double amount) throws Exception {

    }

}
