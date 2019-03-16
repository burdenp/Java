// Assignment 10 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 27 March 2012


import java.util.*;

/**
 * A class that defines a new permutation code, as well as methods for encoding
 * and decoding of the messages that use this code.
 */
public class PermutationCode{
  /** The original list of characters to be encoded */
  ArrayList<Character> alphabet = 
        new ArrayList<Character>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
            't', 'u', 'v', 'w', 'x', 'y', 'z'));
  
  ArrayList<Character> code = new ArrayList<Character>(26);
  
  /** A random number generator */
  Random rand = new Random();
  
  /**
   * Create a new instance of the encoder/decoder with a new permutation code 
   */
  PermutationCode(){
    this.code = this.initEncoder();
  }
  
  /**
   * Create a new instance of the encoder/decoder with the given code 
   */
  PermutationCode(ArrayList<Character> code){
    this.code = code;
  }
  
  /** Initialize the encoding permutation of the characters */
  ArrayList<Character> initEncoder(){
	ArrayList<Character> alphabet2 = alphabet;
    ArrayList<Character> temp = new ArrayList<Character>(26);
    for(int index = 0; index < 26; index = index + 1){
    	int randNum = rand.nextInt(26 - index);
    	temp.add(alphabet2.get(randNum));
    	alphabet2.remove(randNum);
    }
    return temp;
    
  }
  
  /**
   * produce an encoded <code>String</code> from the given <code>String</code>
   * @param source the <code>String</code> to encode
   * @return the secretly encoded <String>
   */
  String encode(String source){
	  String temp = "";
    for(int index = 0 ; index < source.length() ; index = index +1){
    		temp = temp + this.code.get(this.alphabet.indexOf(source.charAt(index)))
    				.toString();
    }
    return temp;
  }
  
  /**
   * produce an decoded <code>String</code> from the given <code>String</code>
   * @param source the <code>String</code> to decode
   * @return the revealed <String>
   */
  String decode(String code){
	  String temp = "";
	  for(int index = 0 ; index < code.length(); index = index +1){
		  temp = temp + alphabet.get(this.code.indexOf(code.charAt(index)))
				  .toString();
	  }
	  return temp;
  }
  //used to test initEncoder so that we can see if it makes a random list
  ArrayList<Character> codeList(){
	  return this.code;
  }
}