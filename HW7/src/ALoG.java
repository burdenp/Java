// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

// to represent an abstract List of groups
public abstract class ALoG implements ILoG{
	
	
	public ALoG(){}
	//helper method for join
	public boolean joinHelper(Person p){
		return false;
	}
	//helper method for drop
	  public boolean dropHelp(Person p){
		  return false;
	  }
	  // helper method for drop
	 public ALoG gHelp(Group g){
		 return new MtLoG();
		 }
	 //checks to see if two groups are the same
	 public boolean sameGroup(ALoG g){
		 return false;
	 }
	 //helper method to see if a person is in the group
	 public boolean groupHelper(Group g){
		 return false;
	 }
	 // checks to see if a group exists/throws an error if not
	 public Group groupsExist(String name){
		 throw new RuntimeException("Group Does Not Exist");
	 }
}