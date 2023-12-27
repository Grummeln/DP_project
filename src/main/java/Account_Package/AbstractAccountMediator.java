package Account_Package;



public interface AbstractAccountMediator {
    void addSenderAcc(Account acc);
    void addRecipientAcc(Account acc);
    void addSum(double sum);
    void notifyTransaction();
}
