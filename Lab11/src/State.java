import java.util.*;

/**
 * Class to represent one US state with its capital
 * Student version.
 * 
 * @author Viera K. Proulx
 *
 */
public class State{

  /** the name of this state */
  String name;
  
  /** the city object that represents the capital */
  City capital;
  
  /** the list of names of neighboring states */
  ArrayList<String> neighbors;
  
  /** the constructor */
  State(String name, 
        City capital, 
        ArrayList<String> neighbors){
    this.name = name;
    this.capital = capital; 
    this.neighbors = neighbors;
  }
 
  
  /** print the city data */
  public String toString(){
    return ("new " + getClass() + "(" + 
            this.name  + ",  " + 
            this.capital + ", " + 
            arlist2String(this.neighbors) + ")\n");
  }
  
  /** helper method to produce a String of neighboring states */
  public String arlist2String(ArrayList<String> arrlist){
    String result = "[list: ";
    for (String s: arrlist){
      result = result + s + ", ";
    }
    result = result.substring(0, result.length()-2);
    return result + "]";
  }
 }