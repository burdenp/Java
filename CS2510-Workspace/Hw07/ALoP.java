// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

// to represent an abstract List of persons
public abstract class ALoP implements ILoP{
	
	public ALoP(){}
	 public void join(Group g){}
	 public boolean joinHelper(Person p){
		 return true;
	 }
	  public boolean dropHelp(Person p){
		  return true;
	  }
	  public ALoP gCompare(Person p){
			 return new MtLoP();
		 }
	  public Person find(String name, int age){
		  throw new RuntimeException("Person Does Not Exist");
		  }
	  }
	/*
	 * Template
	 * FIELDS
	 * ...this.comp... --ICompareBooks
	 * METHODS:
	 * METHODS FOR FIELDS:
	 */