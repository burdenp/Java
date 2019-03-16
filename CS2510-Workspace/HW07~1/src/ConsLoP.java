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
 public void join(Group g){
	  this.first.join(g);
	  this.rest.join(g);
	  }
 public ALoP gCompare(Person p){
	 if(first.name.equals(p.name)){
		 return this.rest;
	 }else{
		 return new ConsLoP(this.first, this.rest.gCompare(p));
	 }
 }
 public Person find(String name, int age){
	  if(this.first.name.equals(name) && this.first.age == age){
		  return this.first;
	  }else{
		  return this.rest.find(name, age);
	  }
 }
}
  
