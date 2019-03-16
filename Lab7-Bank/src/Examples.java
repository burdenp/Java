import tester.*;

// Bank Account Examples and Tests
public class Examples {

    public Examples(){ reset(); }
    
    Account check1;
    Account savings1;
    Account credit1;
    Bank bank1;
    ILoA empty;
    ILoA list1;
    ILoA list2;
    ILoA list3;
    Bank bank2;
    // Initializes accounts to use for testing with effects.
    // We place inside reset() so we can "reuse" the accounts
    public void reset(){
        
        // Initialize the account examples
        check1 = new Checking(1, 100, "First Checking Account", 20);
        savings1 = new Savings(4, 200, "First Savings Account", 2.5);
        credit1 = new Credit(100, 100, "First Credit Account", 100, 1.5);
        bank1 = new Bank("First Bank");
        empty = new MtLoA();
        list1 = new ConsLoA(check1, empty);
        list2 = new ConsLoA(savings1, list1);
        list3 = new ConsLoA(credit1, list2);
        bank2 = new Bank("Second Bank", list3);
    }
    
    // Tests the exceptions we expect to be thrown when
    //   performing an "illegal" action.
    public void testExceptions(Tester t){
        reset();
        t.checkException("Test for invalid Checking withdraw",
                         new RuntimeException("Over Withdrawn"),
                         this.check1,
                         "withdraw",
                         1000);
        t.checkException("Testing withdraw checking",
        	    new RuntimeException("Over Withdrawn"), 
        	    this.check1,
        	    "withdraw",
        	    1000);
    }
 // Test the withdraw method(s)
   public void testWithdraw(Tester t){
      reset();
      t.checkExpect(check1.withdraw(25), 75);
      
      t.checkExpect(check1, new Checking(1, 75,
                    "First Checking Account", 20));
      reset();
      t.checkExpect(savings1.withdraw(25), 175);
      
      t.checkExpect(savings1, new Savings(4, 175,
                    "First Savings Account", 2.5));
      reset();
      t.checkExpect(credit1.withdraw(25), 75);
      
      t.checkExpect(credit1, new Credit(100, 100,
                    "First Credit Account", 75, 1.5));
    }
    // Test the deposit method(s)
    public void testDeposit(Tester t){
        reset();
        t.checkExpect(check1.deposit(25), 125);
        t.checkExpect(check1, new Checking(1, 125, "First Checking Account", 20));
        reset();
        t.checkExpect(savings1.deposit(25), 225);
        t.checkExpect(savings1, new Savings(4, 225, "First Savings Account", 2.5));
        reset();
        t.checkExpect(credit1.deposit(25), 125);
        t.checkExpect(credit1, new Credit(100, 100, "First Credit Account", 125, 1.5));
        reset();
    }
    public void testAdd(Tester t){
    	reset();
    	bank1.add(check1);
    	t.checkExpect(bank1, new Bank("First Bank", new ConsLoA(check1, new MtLoA())));
        reset();
    }
    public void testBankDeposit(Tester t){
    	reset();
    	bank1.add(check1);
    	bank1.deposit("First Checking Account", 1, 50);
    	t.checkExpect(bank1, new Bank("First Bank", new ConsLoA(new Checking(1, 150, "First Checking Account", 20), empty)));
    	reset();
    }
}
