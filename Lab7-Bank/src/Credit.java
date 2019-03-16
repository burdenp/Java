
// Represents a credit line account
public class Credit extends Account{

    int creditLine;  // Maximum amount accessible
    double interest; // The interest rate charged
    
    public Credit(int accountNum, int balance, String name, int creditLine, double interest){
        super(accountNum, balance, name);
        this.creditLine = creditLine;
        this.interest = interest;
    }
    // EFFECT: Withdraw the given amount
    // Return the new balance
    public int withdraw(int amount){	 
    	if(this.creditLine < amount)
    	{
    		throw new RuntimeException("Not Enough Credit");
    	}else{
    		this.creditLine = creditLine - amount;
    		return this.creditLine;
    	}
    }
    // EFFECT: Deposit the given funds into this account
    // Return the new balance
    public int deposit(int funds){
    	 this.creditLine = creditLine + funds;
		 return this.creditLine;
    }
}
