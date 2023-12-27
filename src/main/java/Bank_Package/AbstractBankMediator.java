package Bank_Package;


import Client_Package.Client;

public interface AbstractBankMediator {
    public void addBank(Bank bank);
    public void addClient(Client cl);
    public void notifyStatus();
}
