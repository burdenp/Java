// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

// to represent an abstract List of persons
public abstract class ALoP implements ILoP{
	
	
	/*
	 * Template
	 * FIELDS
	 * METHODS:
	 * ...this.join...
	 * ...this.joinHelper... --boolean
	 * ...this.dropHelp... --boolean
	 * ...this.gCompare...    --ALoP
	 * ...this.find... --Person
	 * METHODS FOR FIELDS:
	 */
	
	public ALoP(){}
	//joins a list of people to a group
	 public void join(Group g){}
	 //helper method for join
	 public boolean joinHelper(Person p){
		 return true;
	 }
	 //helper method for drop
	  public boolean dropHelp(Person p){
		  return true;
	  }
	  // Takes a person and sees if they're included in a group
	  public ALoP gCompare(Person p){
			 return new MtLoP();
		 }
	  // finds a person in a list of people
	  public Person find(String name, int age){
		  throw new RuntimeException("Person Does Not Exist");
		  }
	//helper for joinHelper
	public boolean nameInList(Person p){
		return false;
	}
}
	