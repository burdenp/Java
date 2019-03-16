// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

// to represent an abstract List of groups
public abstract class ALoG implements ILoG{
	
	public ALoG(){}
	public boolean joinHelper(Person p){
		return false;
	}
	  public boolean dropHelp(Person p){
		  return false;
	  }
	 public ALoG gHelp(Group g){
		 return new MtLoG();
		 }
	 public boolean sameGroup(ALoG g){
		 return false;
	 }
	 public boolean groupHelper(Group g){
		 return false;
	 }
	 public Group groupsExist(String name){
		 throw new RuntimeException("Group Does Not Exist");
	 }
}
	
	/*
	 * Template
	 * FIELDS
	 * ...this.comp... --ICompareBooks
	 * METHODS:
	 * METHODS FOR FIELDS:
	 */