// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

// to represent a Person
class Person{
  String name;
  int age;
  ALoG groups;
  
  Person(String name, int age, ALoG groups){
    this.name = name;
    this.age = age;
    this.groups = groups;
  }
public void join(Group g){
	if (this.age < g.limit){
		throw new RuntimeException("Under Age");
	} if (g.members.joinHelper(this)){
		throw new RuntimeException("Already In Group");
	} else {
		this.groups = new ConsLoG (g, groups);
		}
	}
public void dropGroup(Group g){
	if(g.members.dropHelp(this)){
		throw new RuntimeException ("Not In Group");
	} else { 
		this.groups = this.groups.gHelp(g);
		g.members.gCompare(this);
		}
	}
public boolean canMeet(Person p){
	return this.groups.sameGroup(p.groups);
}
}