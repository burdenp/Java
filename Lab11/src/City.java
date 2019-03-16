/**
 * A simple class to use for learning about hashCode and equals.
 * Student version.
 * 
 * @author Viera K. Proulx
 * @since  24 March 2012
 */

import java.text.*;         // to get DecimalFormat

class City{

  /*-------------------------------------------------------------------------
     Member data 
   *-----------------------------------------------------------------------*/

  /** The zip code for this city. */
  public int zip;

  /** The name of this city. */
  public String name;

  /** The state for this city */
  public String state;

  /** The longitude for this city */
  public double longitude;

  /** The latitude for this city */
  public double latitude;

  /** Decimal format to print leading zeros in zip code */
  public static DecimalFormat zipFormat = new DecimalFormat("00000");

  /*-------------------------------------------------------------------------
     Constructor
   *-----------------------------------------------------------------------*/

  /** The full constructor */
  public City (int zip, String name, String state, 
      double longitude, double latitude){
    this.zip   = zip;
    this.name  = name;
    this.state = state;
    this.longitude = longitude;
    this.latitude  = latitude;
  }    

  /** The constructor that allows zip code input as a <code>String</code> */
  public City (String zip, String name, String state, 
      double longitude, double latitude){
    this.zip = this.decimal(zip);
    this.name  = name;
    this.state = state;
    this.longitude = longitude;
    this.latitude  = latitude;
  }

  /** The default constructor */
  public City(){
    this.zip   = 48170;
    this.name  = "Plymouth";
    this.state = "MI";
    this.longitude  = 83.479946;
    this.latitude = 42.368820;
  }

  /*-------------------------------------------------------------------------
     Methods 
   *-----------------------------------------------------------------------*/
  /** 
   * Determine whether this city is in the given state 
   * @param aState the given state
   */
  boolean isInState(String aState){
    return this.state.equals(aState);
  }
  public boolean equals(Object obj){
	  City temp = (City)obj;
	 return this.name == temp.name &&
			 this.sameDouble(this.latitude, temp.latitude, .0001) &&
			 this.sameDouble(this.longitude, temp.longitude, .0001) &&
			 this.zip == temp.zip &&
			 this.state == temp.state;
	  
  }
  //sums the hashcode of all the fields in City Class
  public int hashCode(){
	  Integer tempZip = this.zip;
	  Double tempLat = this.latitude;
	  Double tempLon = this.longitude;
	  
	  return tempZip.hashCode() +
			 this.name.hashCode() +
			 tempLat.hashCode() +
			 tempLon.hashCode() +
			 this.state.hashCode();
  }
  /** helper method to compare doubles */
  protected boolean sameDouble(double d1, double d2, double limit){
    return Math.abs(d1 - d2) < limit;
  }
 
  
  /** Represent  city data as a String for printed display */
  public String toString(){
    return ("new " + getClass() + "(" + 
        City.zipFormat.format(this.zip)   + ",   " + 
        this.name  + ",  " + 
        this.state + ", " + 
        this.longitude + ", " + 
        this.latitude + ")\n");
  }

  
  /** Helper: converts zip code String to integer */
  public int decimal(String s){

    char[] c = s.toCharArray();
    int n = 0;
    for (int i = 0; i < 5; i++){
      n = 10 * n + Character.digit(c[i], 10);
    }
    return n;
  }

}
