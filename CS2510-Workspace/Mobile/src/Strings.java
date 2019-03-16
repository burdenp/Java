// CS 2510 Spring 2012
// Lab 4

import tester.*;

// to represent a list of Strings
interface ILoS{
  // combine all Strings in this list into one
  String combine();
  Boolean isSorted();
  Boolean isSortedAfter(String that);
  ILoS merge(ILoS that);
  String compareFirsts(String that);
}

// to represent an empty list of Strings
class MtLoS implements ILoS{
  MtLoS(){}
  
  // combine all Strings in this list into one
 public String combine(){
    return "";
  }  
 public Boolean isSorted(){
	 return true;
 }
 public Boolean isSortedAfter(String that){
	 return true;
 }
 public ILoS merge(ILoS that){
	 return that;
 }
 
 
 public String compareFirsts(String that){
	 return that;
 }
 

 
}

// to represent a nonempty list of Strings
class ConsLoS implements ILoS{
  String first;
  ILoS rest;
  
  ConsLoS(String first, ILoS rest){
    this.first = first;
    this.rest = rest;  
  }

 /*
  TEMPLATE
  FIELDS:
  ... this.first ...         -- String
  ... this.rest ...          -- ILoS
  
  METHODS
  ... this.combine() ...      -- String
  
  METHODS FOR FIELDS
  ... this.first.concat(String) ...       -- String
  ... this.first.compareTo(String) ...    -- int
  ... this.rest.combine() ...             -- String
  
  */
  
  // combine all Strings in this list into one
  public String combine(){
    return this.first.concat(this.rest.combine());
  }  
  public Boolean isSorted(){
	  return this.rest.isSortedAfter(this.first) &&
			  this.rest.isSorted();
  }
  public Boolean isSortedAfter(String that){
	  if(this.first.compareTo(that) > 0){
		  return true;
	  }
	  else{
		  return false;
	  }
  }
  //merge consumes two sorted lists of strings and produces 
  //a list alphabetically sorted
  public ILoS merge(ConsLoS that){
	 return new ConsLoS(that.compareFirsts(this.first, this),	 
  }
  
  public ILoS merge(MtLoS that){
	  
  }
  
  
  //compares the first two items of the lists
  public String compareFirsts(ConsLoS thatlist){
		 if(this.first.compareTo(thatlist.first) > 0){
			 return that;
		 } else {
			 return this.first;
		 }
	 }
  
 
}

// to represent examples for lists of strings
class ExamplesStrings{
  ExamplesStrings(){}
  
  ILoS mary = new ConsLoS("Mary ",
               new ConsLoS("had ",
                new ConsLoS("a ",
                 new ConsLoS("little ",
                  new ConsLoS("lamb.", new MtLoS())))));
                          
  boolean testCombine(Tester t){
    return 
    t.checkExpect(this.mary.combine(), "Mary had a little lamb.");
  }
}