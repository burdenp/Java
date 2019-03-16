/** 
 * An implementation of <code>Traversal</code> that reads a text file
 * with <code>City</code> data encoded as well-formatted 
 * <code>String</code>s and generates one instance at a time.
 * 
 * @since 24 March 2012
 * @author Viera K. Proulx
 */

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import java.text.ParseException;
import java.util.*;

import tester.*;

class InFileCityTraversal implements Traversal<City>{
  
  /*-------------------------------------------------------- 
   Member data
   *------------------------------------------------------*/
  
  /** the input reader */
  protected BufferedReader buffer;
  
  /** one line of input at a time */
  protected String line;
  
  /** a City object to hold values */
  protected City c;
  
  /** determines whether the general dialog has been closed */
  protected boolean closed = true;
  
  /** determines whether new T data has been submitted */
  protected boolean submitted = false;
  
  /** 
   * an instance of a class that converts <code>City</code> data
   * to a <code>String</code> and produces a <code>City</code> from
   * a well-formatted <code>String</code>
   */
  protected CityConverter cc = new CityConverter();
  
  /*-------------------------------------------------------- 
   Constructor
   *------------------------------------------------------*/    
  public InFileCityTraversal() {
    
    /** build a file chooser 
     and have the user choose a file, 
     quitting this operation 
     if the user cancelled the choice */
    JFileChooser chooser = new JFileChooser(".");
    
    /** set the file extension to be .txt */
    chooser.setFileFilter(new TextFileFilter());
    
    this.closed = false;
    
    /** see if file was selected - quit if user canceled */
    if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION){
      this.closed = true;
      return;
    }
    try{
      this.buffer = new BufferedReader(
          new FileReader(chooser.getSelectedFile()));
    }
    catch(FileNotFoundException e){
      System.out.println("File not found exception: " + e);
      this.closed = true;        
    }
    
    
    /** read one line of input from the selected file 
     *  and extract values for the first city */
    getnext();
  }
  /*--------------------------------------------------------
   Methods to implement the Traversal interface
   *------------------------------------------------------*/
  
  /** process next item, if available */
  public void getnext() {
    
    if (!this.closed)
      try{
        if (this.buffer.ready()){
          
          this.line = new String(this.buffer.readLine());
          if ((this.line == null)||(this.line == "")){     
            this.buffer.close();
            this.closed = true;
          }
          else{ 
            read(this.line);
          }            
        }
        else{
          this.buffer.close();
          this.closed = true;
        }
      }
    catch(Exception e) {
      System.out.println("Error in reading line exception: " + e);
      this.closed = true;
    }
    
  }
  
  /** advance to the next element in the dataset */
  public Traversal<City> getRest(){
    getnext();
    return this;
  }
  
  /** return the most recent submission - if available */
  public City getFirst() {
    
    if (!this.closed)
      return this.c;
    else{
      this.closed = true;
      return null;
    }
  }
  
  /** verify that new submission is available */
  public boolean isEmpty() {
    return this.closed; 
  }
  
  /** extract next Stringable object from the input string */
  public void read(String str){
    
    try {
      this.c = this.cc.fromStringData(str);
    }
    catch(java.text.ParseException e){
      System.out.println(e.getMessage() + 
          " parse exception in line\n" + 
          this.line);
      this.c = null;
      this.closed = true;
    }
  }
}

/**
 * A class to provide a conversion from <code>City</code> data to a well-formated 
 * <code>String</code> and a conversion from a well-formatted <code>String</code>
 * to an instance os a <code>City</code>
 * 
 * @author Viera K. Proulx
 *
 */
class CityConverter{

  /** Convert <CODE>City</CODE> data to well structured string 
   * for file output*/
  public String toStringData(City that){
    String s = "" + City.zipFormat.format(that.zip) + ", " +
    that.name  + ", " +
    that.state + ", " +
    that.longitude + ", " +
    that.latitude  + "\n";
    return s;
  }

  /** Convert the <CODE>String</CODE> that represents a <CODE>City</CODE>
   *  to city data */
  public City fromStringData(String s) throws java.text.ParseException{
    City city = new City();
    try{
      /** set up the string tokenizer to extract city data */
      StringTokenizer st = new StringTokenizer(s, ",");

      city.zip       = Integer.valueOf(st.nextToken());
      city.name      = st.nextToken();
      city.state     = st.nextToken();
      city.longitude = Double.valueOf(st.nextToken());
      city.latitude  = Double.valueOf(st.nextToken());

      return city;
    }
    catch(NoSuchElementException e){
      System.out.println(e.getMessage());
      throw new java.text.ParseException("Tokenizer Error", 0);
    }
  }

  /** show how the String conversion works */
  public void testScanner(){

    City boston = new City("02115", "Boston", "MA", 71.092215, 42.342706);

    // encode City data as a String
    String str = this.toStringData(boston);
    System.out.println("Encoded string: " + str);

    // use the encoded String to initialize new City fields
    City temp = new City();
    try{
      temp = this.fromStringData(str);
    }
    catch(ParseException e){
      System.out.println("Parse error: " + str + "\n" + e.getMessage());
    }

    // print out the new objecct
    System.out.println(temp);
  }

}

/**
 * Class used to assure that only file names with the suffix .txt are
 * seen in the FileChooser dialog.
 * 
 * @author Viera K. Proulx
 * @since 7 March 2008
 *
 */
class TextFileFilter extends FileFilter{

  public boolean accept(File f){
    // accept if file name ends in .txt
    return f.getName().endsWith(".txt");
  }

  public String getDescription(){
    return "Text files";
  }

}
