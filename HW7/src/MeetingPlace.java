// Assignment 7 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 27 February 2012

//keep track of the list of people signed up to the network and list of groups
class MeetingPlace {
	  ConsLoP listOfPeople;
	  ConsLoG listOfGroups;
	  
	  MeetingPlace(ConsLoP listOfPeople, ConsLoG listOfGroups){
		  this.listOfPeople = listOfPeople;
		  this.listOfGroups = listOfGroups;
		  
			/*
			 * Template
			 * FIELDS
			 * ...this.ListOfPeople... --ConsLoP
			 * ...this.ListOfGroups... --ConsLoG
			 * METHODS:
			 * ...this.join...
			 * ...this.remove...
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
			 * ...this.first.join...
			 * ...this.first.dropGroup...
			 * ...this.first.canMeet...  --boolean
			 *...this.rest.join... 
			 * ...this.rest.gCompare... --ALoP
			 *...this.rest.find...  --Person
			 */
	  }
	  //Joins a person to a group
	  public void join(String pName, int age, String gName){
			 listOfPeople.find(pName, age).join(listOfGroups.groupsExist(gName));
	  }
	  // removes a person from a group
	 public void remove(String pName, int age, String gName){
		 listOfPeople.find(pName, age).dropGroup(listOfGroups.groupsExist(gName));
	 }
}