
// Represents a savings account
public class Savings extends Account{

    double interest; // The interest rate

    public Savings(int accountNum, int balance, String name, double interest){
        super(accountNum, balance, name);
        this.interest = interest;
    }
    // EFFECT: Withdraw the given amount
    // Return the new balance
    public int withdraw(int amount){	 
    	if(this.balance < amount)
    	{
		 throw new RuntimeException("Over Withdrawn");
    	}else{
    		this.balance = balance -amount;
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
