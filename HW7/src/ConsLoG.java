// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

// to represent a nonempty list of groups
class ConsLoG extends ALoG{
  Group first;
  ALoG rest;
  
  ConsLoG(Group first, ALoG rest){
    this.first = first;
    this.rest = rest;
  }
  
	/*
	 * Template
	 * FIELDS
	 * ...this.first...
	 * ...this.rest....
	 * METHODS:
	 * ...this.joinHelper... --boolean
	 * ...this.dropHelp... --boolean
	 * ...this.gHelp...    --ALoG
	 * ...this.sameGroup... --boolean
	 * ...this.groupHelper... --boolean
	 * ...this.groupsExist... --group
	 * METHODS FOR FIELDS:
	 * ...this.first.joinHelper... --boolean
	 * ...this.first.dropHelp... --boolean
	 * ...this.first.gCompare...    --ALoP
	 * ...this.first.find... --Person\
	 *...this.rest.joinHelper... --boolean
	 * ...this.rest.dropHelp... --boolean
	 * ...this.rest.gHelp...    --ALoG
	 * ...this.rest.sameGroup... --boolean
	 * ...this.rest.groupHelper... --boolean
	 * ...this.rest.groupsExist... --group
	 */
  
  // helper method for join
  public boolean joinHelper(Person p){
	  return this.first.members.nameInList(p) ||
			 this.rest.joinHelper(p);
  }  
  // helper method for drop
  public boolean dropHelp(Person p){
	  return ! p.name.equals(this.rest) ||
			 this.rest.dropHelp(p);
}
  //Helper method for drop
 public ALoG gHelp(Group g){
	 if(first.name.equals(g.name)){
		return this.rest;
	 } else{
		return new ConsLoG(this.first, this.rest.gHelp(g));
	 }
 }
 //checks to see if two groups are the same
 public boolean sameGroup(ALoG g){
	 return g.groupHelper(this.first) ||
			 this.rest.sameGroup(g);
 }
 // helper method for samegroup
 public boolean groupHelper(Group g){
	 return this.first.name.equals(g.name);
 }
 //checks to see if a group is in a list of groups
 public Group groupsExist(String name){
	 if(this.first.name.equals(name)){
		 return this.first;
	 }else{
		 return this.rest.groupsExist(name);
	 }
 }
}