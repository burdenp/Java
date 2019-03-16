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
  public boolean joinHelper(Person p){
	  return p.name.equals(this.rest) ||
			 this.rest.joinHelper(p);
  }  
  public boolean dropHelp(Person p){
	  return ! p.name.equals(this.rest) ||
			 this.rest.dropHelp(p);
}
 public ALoG gHelp(Group g){
	 if(first.name.equals(g.name)){
		return this.rest;
	 } else{
		return new ConsLoG(this.first, this.rest.gHelp(g));
	 }
 }
 public boolean sameGroup(ALoG g){
	 return g.groupHelper(this.first) ||
			 this.rest.sameGroup(g);
 }
 public boolean groupHelper(Group g){
	 return this.first.name.equals(g.name);
 }
 public Group groupsExist(String name){
	 if(this.first.name.equals(name)){
		 return this.first;
	 }else{
		 return this.rest.groupsExist(name);
	 }
 }
}