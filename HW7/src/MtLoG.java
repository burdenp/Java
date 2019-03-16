// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

class MtLoG extends ALoG{
  MtLoG(){  
	  
	  /*
	   * Template
	   * FIELDS
	   
	   * METHODS:
	   * ...this.inGroup...  --boolean
	   * ...this.dropHelp... --boolean
	   * ...this.gHelp...  --ALoG
	   * METHODS FOR FIELDS:
	   
	   */
	  
  }
  // checks if a person is in a group
  public boolean inGroup(Person p){
	  return false;
  }
  // helper method for join
  public boolean joinHelper(Person p){
	  return false;
	}
  // helper method for drop
  public boolean DropHelp(Person p){
	  return true;
  }
  //another helper method for drop
  public ALoG gHelp(Group g){
		return this;
  }

}

