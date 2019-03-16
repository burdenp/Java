// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

// to represent a Group
class Group{
  String name;
  int limit;
  ALoP members;
  
  Group(String name, int limit, ALoP members){
    this.name = name;
    this.limit = limit;
    this.members = members;
    this.members.join(this);
    }
  
	/*
	 * Template
	 * FIELDS
	 * ...this.name... --String
	 * ...this.limit... -- int
	 * ....this.members --ALoP
	 * METHODS:
	 * METHODS FOR FIELDS:
	 * ...this.join...
	 * ...this.joinHelper... --boolean
	 * ...this.dropHelp... --boolean
	 * ...this.gCompare...    --ALoP
	 * ...this.find... --Person
	 */
}