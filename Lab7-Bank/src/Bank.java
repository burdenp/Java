
// Represents a Bank with list of accounts
public class Bank {
    
    String name;
    ILoA accounts;
    
    public Bank(String name){
        this.name = name;
        // Each bank starts with no accounts
        this.accounts = new MtLoA();
    }
    public Bank(String name, ILoA accounts){
    	this.name =name;
    	this.accounts = accounts;
    }
    void add(Account acct){
    	accounts = new ConsLoA(acct, this.accounts);
    }
    void deposit(String name, int acctNum, int ammount){
    	this.accounts.helper(name, acctNum, ammount);
    }
}
