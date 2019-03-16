
// Represents a non-empty List of Accounts...
public class ConsLoA implements ILoA{

    Account first;
    ILoA rest;

    public ConsLoA(Account first, ILoA rest){
        this.first = first;
        this.rest = rest;
    }
    
    /* Template
     *  Fields:
     *    ... this.first ...         --- Account
     *    ... this.rest ...          --- ILoA
     *
     *  Methods:
     *   
     *  Methods for Fields:
     *
     */
    public void helper(String name, int acctNum, int ammount){
    	if(this.first.name.equals(name) && this.first.accountNum == acctNum){
    		first.deposit(ammount);
    	}else{
    		this.rest.helper(name, acctNum, ammount);
    	}
    }
}