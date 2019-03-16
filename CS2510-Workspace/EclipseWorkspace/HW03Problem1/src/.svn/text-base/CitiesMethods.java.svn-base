import tester.*;

// Assignment 3 Problem 1
// Josh Samara
// joshs
// Patrick Burden
// pburden
// 31 January 2012

//to represent a posn
class Posn{
    public double x;
    public double y;
    
    public Posn(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /* TEMPLATE:
    FIELDS:
     ... this.x ...             -- double
     ... this.y ...             -- double

     METHODS:
     METHODS FOR FIELDS:
    */
}

//to represent a a city
class City{
	Integer zip;
	String name;
	String state; //as a two letter abbreviation
	Loc coords;
	
	City(Integer zip, String name, String state, Loc coords){
		this.zip = zip;
		this.name = name;
		this.state = state;
		this.coords = coords;
	}
	
	
	/* TEMPLATE:
    FIELDS:
     ... this.zip ...          		    -- integer
     ... this.name ...            		-- string
     ... this.state ...            		-- string
     ... this.coords ...           		-- Loc

     METHODS:
     ... this.sameState(String) ...		--boolean
     ... this.isSouthOfHuh(City) ...	--boolean
     ... this.distanceTo(City) ...		--double
     ... this.toPosn(Double,Double) ...	--Posn
     
     METHODS FOR FIELDS:
     ... this.Loc.distance() ...				--double
     ... this.Loc.toPosn(Double, Doubl ...		--Posn
     
    */
	
	//determines whether this city is in a given state
	public boolean sameState(String state){
		return this.state.equals(state);
	}
	
	//determines whether this city is located south of a given city
	//*only works with cities in the northern hemisphere
	public boolean isSouthOfHuh(City that){
		return this.coords.lat < that.coords.lat;
	}
	
	//computes the distance from this city to the given city in miles
	public double distanceTo(City that){
		return this.coords.distance(that.coords);
	}
	
	//converts the Loc within this city into a Posn of a given width and height
	public Posn toPosn(double width, double height){
		return this.coords.toPosn(width, height);
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
	
	/* TEMPLATE:
    FIELDS:
     ... this.lon ...          		    -- double
     ... this.lat ...           		-- double

     METHODS:
     ... this.distance(Loc) ...		    --double
     ... this.toPosn(Double,Double) ...	--Posn
     
     METHODS FOR FIELDS:
    */
	
	//computes the distance from this location to a given location in miles
	public double distance(Loc that){
		return Math.sqrt(	Math.pow(((this.lon - that.lon) * 55),2)
						+	Math.pow(((this.lat - that.lat) * 70),2));
	}
	
	//converts this Loc into a Posn of a given width and height
	public Posn toPosn(double width, double height){
		return new Posn((125 - this.lon)/60 * width,
						(50 - this.lat)/30 * width);
	}
}

//to represent a list of cities
interface IListOfCities{
	
	//computes the total distance traveled through all cities in the list
	public double totalDistance();
	
	//computes the distance to the given city from the first city of the list
	public double totalDistanceAfter(City city);
	
	//adds a city to the route
	public IListOfCities addCity(City toVisit, City addAfter);
	
	//determines whether any city in the list is visited more than once
	public boolean hasLoop();
	
	//checks if a given city appears in this list of cities
	public boolean checkAgainst(City city);
	
}

//a list of cities with at least one item
class ListOfCities implements IListOfCities{
	City first;
	IListOfCities rest;
	
	ListOfCities(City first, IListOfCities rest){
		this.first = first;
		this.rest = rest;
	}
	
	
	/* TEMPLATE:
    FIELDS:
    ... this.first ...          	    -- City
    ... this.rest ...            		-- IListOfCities

     METHODS:
    ... this.totalDistance() ...				--double
	... this.totalDistanceAfter(City) ...		--double
	... this.addCity(City, City) ...			--IListOfCities
	... this.hasLoop() ...                      --boolean
    ... this.checkAgainst(City) ...             --boolean
    
     METHODS FOR FIELDS:
    ... this.first.sameState(String) ...		--boolean
    ... this.first.isSouthOfHuh(City) ...		--boolean
    ... this.first.distanceTo(City) ...			--double
    ... this.first.toPosn(Double,Double) ...	--Posn
     
    ... this.rest.totalDistance() ...				--double
	... this.rest.totalDistanceAfter(City) ...		--double
	... this.rest.addCity(City, City) ...			--IListOfCities
	... this.rest.hasLoop() ...                     --boolean
    ... this.rest.checkAgainst(City) ...            --boolean
     
    */
	
	//computes the total distance traveled through all cities in the list
	public double totalDistance(){
		return this.rest.totalDistanceAfter(this.first)
				+ this.rest.totalDistance();
	}
	
	//computes the distance to the given city from the first city of the list
	public double totalDistanceAfter(City city){
		return this.first.distanceTo(city);
	}
	
	
	//adds a city to the route
	public IListOfCities addCity(City toVisit, City addAfter){
		if (this.first == addAfter){
		   return new ListOfCities(this.first, new ListOfCities(toVisit, this.rest));
		} else {
		   return new ListOfCities(this.first, this.rest.addCity(toVisit, addAfter));
		}					
	}
	
	//determines whether any city in the list is visited more than once
	public boolean hasLoop(){
		return
		this.rest.checkAgainst(this.first)
		||
		this.rest.hasLoop();
	}
	
	//checks if a given city appears in this list of cities
	public boolean checkAgainst(City city){
		return this.first == city || this.rest.checkAgainst(city);
	}
	
}

//an empty list of cities
class MtListOfCities implements IListOfCities{
	
	MtListOfCities(){}
	
	/* TEMPLATE:
    FIELDS:

     METHODS:
    ... this.totalDistance() ...				--double
	... this.totalDistanceAfter(City) ...		--double
	... this.addCity(City, City) ...			--IListOfCities
	... this.hasLoop() ...                      --boolean
    ... this.checkAgainst(City) ...             --boolean
    
    METHODS FOR FIELDS:
    */
	
	//computes the total distance traveled through all cities in the list
	public double totalDistance(){
		return 0;
	}
		
	//computes the distance to the given city from the first city of the list
	public double totalDistanceAfter(City city){
		return 0;
	}
	
	//adds a city to the route
	public IListOfCities addCity(City toVisit, City addAfter){
		return new ListOfCities(toVisit, this);
	}
    
	//determines whether any city in the list is visited more than once
	public boolean hasLoop(){
		return false;
	}
	
	//checks if a given city appears in this list of cities
	public boolean checkAgainst(City city){
		return false;
	}
		
		
}

class ExamplesCities{
	ExamplesCities(){}
	
	
	///DATA EXAMPLES
	Loc l1 = new Loc(71.092215, 42.342706);
	Loc l2 = new Loc(72.675807, 41.78596);
	Loc l3 = new Loc(69.766548, 44.323228);
	City c1 = new City(02115, "Boston", "MA", this.l1);
	City c2 = new City(06120, "Hartford", "CT", this.l2);
	City c3 = new City(04330, "Augusta", "ME", this.l3);
	IListOfCities list1 = new MtListOfCities();
	IListOfCities list2 = new ListOfCities(this.c1, this.list1);
	IListOfCities list3 = new ListOfCities(this.c2, this.list2);
	IListOfCities list4 = new ListOfCities(this.c3, this.list3);
	IListOfCities list5 = new ListOfCities(c3, 
    							new ListOfCities(c2,
    								new ListOfCities(c1, 
    										new ListOfCities(c3, list1))));
	
	
	
	
	//METHOD EXAMPLES
	boolean testSameState(Tester t){
		return 	t.checkExpect(this.c1.sameState("MA"), true) &&
				t.checkExpect(this.c1.sameState("Not MA"), false);
	}
	
	boolean testIsSouthOfHuh(Tester t){
		return 	t.checkExpect(this.c1.isSouthOfHuh(this.c2), false) &&
				t.checkExpect(this.c2.isSouthOfHuh(this.c1), true);			
	}
	
	boolean testDistanceTo(Tester t){
		return t.checkNumRange(this.c1.distanceTo(this.c2), 95, 96);
	}
	
	boolean testToPosn(Tester t){
		return t.checkNumRange(this.c1.toPosn(100, 100).x, 89, 90) &&
				t.checkNumRange(this.c1.toPosn(100, 100).y, 25, 27);
	}
	
	boolean testTotalDistance(Tester t){
		return t.checkNumRange(this.list1.totalDistance(), -1, 1) &&
		       t.checkNumRange(this.list3.totalDistance(), 95, 96) &&
		       t.checkNumRange(this.list4.totalDistance(), 334, 335); 
	}
	
	boolean testAddCity(Tester t){
		return t.checkExpect(this.list1.addCity(c1, c2), list2) &&
			   t.checkExpect(this.list4.addCity(c3, c1), list5);
	}
	
	boolean testHasLoop(Tester t){
		return t.checkExpect(this.list4.hasLoop(), false) &&
			   t.checkExpect(this.list5.hasLoop(), true);
	}
	
	
}