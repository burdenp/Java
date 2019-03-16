interface IAttraction{}

class Address{
	String street;
	int no;
	String city;
	
	Address(String street, int no, String city){
		this.street = street;
		this.no = no;
		this.city = city;
	}
	
}

class Hotel implements IAttraction{
	String name;
	Address addr;
	
	Hotel(String name, Address addr){
		this.name = name;
		this.addr = addr;
	}
}

class Restaurant implements IAttraction{
	String name;
	Address addr;
	String food;
	
	Restaurant(String name, Address addr, String food){
		this.name = name;
		this.addr = addr;
		this.food = food; 
	}
}

class Movie implements IAttraction{
	String name;
	Address addr;
	int shows;
	
	Movie(String name, Address addr, int shows){
		this.name = name;
		this.addr = addr;
		this.shows = shows; 
	}
	
}
class Examples{
	Examples(){}
	
	Address beacon = new Address("Beacon",150,"Boston");
	Address boylston = new Address("Boylston", 150, "Boston");
	Address chestnut = new Address("Chestnut", 25, "Cambridge");
	Hotel h1 = new Hotel("Hilton", beacon);
	Hotel h2 = new Hotel("Hilton", boylston);
	Hotel h3 = new Hotel("Marriot", chestnut);
	IAttraction a1 = h1;
	IAttraction a2 = new Restaurant("Alpha", boylston, "Mexican");
	IAttraction a3 = new Movie("hi", chestnut, 293);
}