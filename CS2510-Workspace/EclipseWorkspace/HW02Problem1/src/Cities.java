import tester.*;


//Assignment 2 Problem 2
//Josh Samara
//joshs
//Patrick Burden
//pburden
//24 January 2012


//to represent a a city
class City{
	Integer zip;
	String name;
	String state;
	Loc coords;
	
	City(Integer zip, String name, String state, Loc coords){
		this.zip = zip;
		this.name = name;
		this.state = state;
		this.coords = coords;
	}
}

//to represent a a location using longitude and latitude
class Loc{
	double lon;
	double lat;
	
	Loc(double lon, double lat){
		this.lon = lon;
		this.lat = lat;
	}
}

//to represent a list of cities
interface IListOfCities{}

//a list of cities with at least one item
class ListOfCities implements IListOfCities{
	City first;
	IListOfCities rest;
	
	ListOfCities(City first, IListOfCities rest){
		this.first = first;
		this.rest = rest;
	}
	
	
}

//an empty list of cities
class MtListOfCities implements IListOfCities{	
	MtListOfCities(){}
}

class ExamplesCities{
	ExamplesCities(){}
	
	Loc l1 = new Loc(71.092215, 42.342706);
	Loc l2 = new Loc(72.675807, 41.78596);
	Loc l3 = new Loc(69.766548, 44.323228);
	
	City c1 = new City(02115, "Boston", "MA", l1);
	City c2 = new City(06120, "Hartford", "CT", l2);
	City c3 = new City(04330, "Augusta", "ME", l3);
	
	IListOfCities list1 = new MtListOfCities();
	IListOfCities list2 = new ListOfCities(c1, list1);
	IListOfCities list3 = new ListOfCities(c2, list2);
	IListOfCities list4 = new ListOfCities(c3, list3);
}