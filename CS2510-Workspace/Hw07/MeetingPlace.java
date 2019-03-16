
class MeetingPlace {
	  ConsLoP listOfPeople;
	  ConsLoG listOfGroups;
	  
	  MeetingPlace(ConsLoP listOfPeople, ConsLoG listOfGroups){
		  this.listOfPeople = listOfPeople;
		  this.listOfGroups = listOfGroups;
	  }
	  public void join(String pName, int age, String gName){
			 listOfPeople.find(pName, age).join(listOfGroups.groupsExist(gName));
	  }
	 public void remove(String pName, int age, String gName){
		 listOfPeople.find(pName, age).dropGroup(listOfGroups.groupsExist(gName));
	 }
}