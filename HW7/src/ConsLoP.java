// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

// to represent a nonempty list of persons
class ConsLoP extends ALoP{
  Person first;
  ALoP rest;
  
  ConsLoP(Person first, ALoP rest){
    this.first = first;
    this.rest = rest;
  }
  
	/*
	 * Template
	 * FIELDS
	 * ...this.first...
	 * ...this.rest....
	 * METHODS:
	 * ...this.join...
	 * ...this.gCompare... --ALoP
	 * ...this.find... --Person
	 * METHODS FOR FIELDS:
	 * ...this.first.join...
	 * ...this.first.dropGroup...
	 * ...this.first.canMeet...  --boolean
	 *...this.rest.join... 
	 * ...this.rest.gCompare... --ALoP
	 *...this.rest.find...  --Person
	 */

  
  // joins a list of people to a group
 public void join(Group g){
	  this.first.join(g);
	  this.rest.join(g);
	  }
 // Takes a person and sees if they're included in a group
 public ALoP gCompare(Person p){
	 if(first.name.equals(p.name)){
		 return this.rest;
	 }else{
		 return new ConsLoP(this.first, this.rest.gCompare(p));
	 }
 }
 // Finds a person in a list of people
 public Person find(String name, int age){
	  if(this.first.name.equals(name) && this.first.age == age){
		  return this.first;
	  }else{
		  return this.rest.find(name, age);
	  }
 }
 //helper for joinHelper
 public boolean nameInList(Person p){
		return p.name.equals(this.first.name) || this.rest.nameInList(p);
	}
}
  
