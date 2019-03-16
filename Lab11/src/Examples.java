import java.util.*;

import tester.*;

/**
 * The test suite for the US map exploration and Lab 11 Spring 2012
 * 
 * @author Viera K. Proulx
 *
 */
public class Examples implements IExamples{
  
  /** data for the methods and tests */
  HashMap<City, State> testMap = new HashMap<City, State>();
  HashMap<City, State> newEngland = new HashMap<City, State>();
  ArrayList<String> NHneighbors = new ArrayList<String>();
  ArrayList<String> VTneighbors = new ArrayList<String>();
  ArrayList<String> MEneighbors = new ArrayList<String>();
  ArrayList<String> CTneighbors = new ArrayList<String>();
  ArrayList<String> RIneighbors = new ArrayList<String>();
  ArrayList<String> MAneighbors = new ArrayList<String>();
  
  City concord = new City("03301", "Concord", "NH", 71.527734, 43.218525);
  City montpellier = new City("05602", "Montpelier", "VT", 72.576992, 44.264082);
  City augusta = new City("04330", "Augusta", "ME", 69.766548, 44.323228);
  City hartford = new City("06120", "Hartford", "CT", 72.675807, 41.78596);
  City providence = new City("02908", "Providence", "RI", 71.437684, 41.838294);
  City boston = new City("02115", "Boston", "MA", 71.092215, 42.342706);
  City boston2 = new City("02115", "Boston", "MA", 71.092215, 42.342706);
  
  State NH = new State("NH", this.concord, this.NHneighbors );
  State VT = new State("VT", this.montpellier, this.VTneighbors );
  State ME = new State("ME", this.augusta, this.MEneighbors );
  State CT = new State("CT", this.hartford, this.CTneighbors);
  State RI = new State("RI", this.providence, this.RIneighbors);
  State MA = new State("MA", this.boston, this.MAneighbors);
  
  
  
  /** generate lists of neighboring states */
  public void makeNewEngland(){
    this.NHneighbors.add("ME");
    this.NHneighbors.add("MA");
    this.NHneighbors.add("VT");
    
    this.VTneighbors.add("NH");
    this.VTneighbors.add("MA");

    this.MEneighbors.add("NH");
    
    this.CTneighbors.add("RI");
    
    this.RIneighbors.add("CT");
    this.RIneighbors.add("MA");
    
    this.MAneighbors.add("RI");
    this.MAneighbors.add("NH");
    this.MAneighbors.add("VT");
  }
  
  /** generate New England states */
  public void makeStates(){
    
    this.newEngland.put(this.concord, this.NH);
    this.newEngland.put(this.montpellier, this.VT);
    this.newEngland.put(this.augusta, this.ME);
    this.newEngland.put(this.hartford, this.CT);
    this.newEngland.put(this.providence, this.RI);
    this.newEngland.put(this.boston, this.MA);
  }
  public void initMap(HashMap<City, State> states){
	states.put(this.concord, this.NH);
	states.put(this.montpellier, this.VT);
	states.put(this.augusta, this.ME);
	states.put(this.hartford, this.CT);
	states.put(this.providence, this.RI);
	states.put(this.boston, this.MA);
	states.put(this.boston2, this.MA);
  }

  ArrayList<City> cities = new ArrayList<City>();

  /** initialize cities with the data from a file */
  public void initCities(){
    Traversal<City> tr = new InFileCityTraversal();

    try{
      while (!tr.isEmpty()){
        this.cities.add(tr.getFirst());
        tr= tr.getRest();
      }
    }
    catch(IllegalUseOfTraversalException e){
      System.out.println(
          "IllegalUseOfTraversalException: cannot happen" +
          e.getMessage());
    } 
  }
  
  /**
   * The test driver
   */
  public void tests(Tester t){
    this.makeNewEngland();
    this.makeStates();
    
    System.out.println("After initialization:");
    System.out.println("Concord: " + this.newEngland.get(this.concord));
    System.out.println("Montpellier: " + this.newEngland.get(this.montpellier));
    System.out.println("Augusta: " + this.newEngland.get(this.augusta));
    
    initCities();
    for (City c: this.cities){
      System.out.println(c.toString());
    }
    initMap(testMap);
    t.checkExpect(testMap.size(), 6);
    t.checkExpect(testMap.containsValue(CT), true);
  }
  
}