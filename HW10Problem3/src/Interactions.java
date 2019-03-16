// Assignment 10 Problem 3
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 27 March 2012


/**
 * Interactions driver for the Eliza game.
 * 
 * @since 19 March 2012 
 */

import java.io.*;
import java.util.ArrayList;

public class Interactions{
  
  /**
   * Run the program - starting with the <code>eliza</code>
   * method.
   * 
   * @param args unused
   */
  public static void main(String[] args) {   
    
    Interactions i = new Interactions();
    i.eliza();
  }
  
  /**
   * Run the Eliza game
   */ 
  public void eliza(){
  
    BufferedReader input =
      new BufferedReader(new InputStreamReader(System.in));
    
    ArrayList<String> whoList = new ArrayList<String>();
    whoList.add("Him");
    whoList.add("Her");
    whoList.add("They");
    Reply r1 = new Reply("who", whoList);
    ArrayList<String> whyList = new ArrayList<String>();
    whyList.add("I wanted to");
    whyList.add("I can");
    whyList.add("To see what would happen");
    Reply r2 = new Reply("why", whyList);
    ArrayList<String> howList = new ArrayList<String>();
    howList.add("It depends");
    howList.add("It is up to you");
    howList.add("Its complicated");
    Reply r3 = new Reply("how", howList);
    ArrayList<String> whereList = new ArrayList<String>();
    whereList.add("In the car");
    whereList.add("In the house");
    whereList.add("In the office");
    Reply r4 = new Reply("where", whereList);
    ArrayList<String> whenList = new ArrayList<String>();
    whenList.add("In the morning");
    whenList.add("In the afternoon");
    whenList.add("At night");
    Reply r5 = new Reply("when", whenList);
    ArrayList<String> whatList = new ArrayList<String>();
    whatList.add("Google it");
    whatList.add("Say what again");
    whatList.add("Its a long story");
    Reply r6 = new Reply("what", whatList);
    ArrayList<Reply> elList = new ArrayList<Reply>();
    elList.add(r1);
    elList.add(r2);
    elList.add(r3);
    elList.add(r4);
    elList.add(r5);
    elList.add(r6);
    Eliza el = new Eliza(elList);
    
    System.out.println("Ask me a question. \n:>");
    try{
      String s = input.readLine();
      while (!(s == null) && s.length() > 0){

        s = el.firstWord(s);
        for(int index = 0; index < el.list.size(); index = index +1)
        if(s.equals(el.list.get(index).keyword)){
        	System.out.println(el.list.get(index).RandomAnswer());
        	break;
        }else if(index +1 == el.list.size()){
        	System.out.println("I do not know");
        }
        
        System.out.println(":>");
        s = input.readLine();
        if (s == null || s.length() == 0){
          System.out.println("Goodbye");
        }
      }
    }
    catch(IOException e){
      System.out.println("Goodbye");
    }  
  }
}

