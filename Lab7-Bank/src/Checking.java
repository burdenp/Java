
// Represents a checking account
public class Checking extends Account{

    int minimum; // The minimum account balance allowed

    public Checking(int accountNum, int balance, String name, int minimum){
        super(accountNum, balance, name);
        this.minimum = minimum;
    }
    // EFFECT: Withdraw the given amount
    // Return the new balance
     public int withdraw(int amount){
    	 if(this.balance < amount)
    	 {
    		 throw new RuntimeException("Over Withdrawn");
    	 }else{
    		 this.balance = balance - amount;
    		 return this.balance;
    	 }
     }
     // EFFECT: Deposit the given funds into this account
     // Return the new balance
     public int deposit(int funds){
    	 this.balance = balance + funds;
		 return this.balance;
     }
}
