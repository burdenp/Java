// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

class MtLoG extends ALoG{
  MtLoG(){  
  }
  public boolean inGroup(Person p){
	  return false;
  }
  public boolean joinHelper(Person p){
	  return false;
	}
  public boolean DropHelp(Person p){
	  return true;
  }
  public ALoG gHelp(Group g){
		return this;
  }

}
  /*
   * Template
   * FIELDS
   
   * METHODS:

   * METHODS FOR FIELDS:
   
   */
