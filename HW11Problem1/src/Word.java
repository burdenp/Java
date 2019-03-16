

// Assignment 1 Problem 1
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username Seydi
// 2 April 2012


import java.util.*;

/** <code>Word</code> represents a word and its number of occurrences */
public class Word{
	String s;
	Integer freq;
	Comparator<Word> f;
    public Word(String s){
        this.s = s;
        this.freq = 1;
        this.f = new WordsByFreq();
    }
  
    /** Is this Word equal to the given Object */
    public boolean equals(Object obj){
        Word word = (Word) obj;
    	return this.s.equalsIgnoreCase(word.s);
    }
  
    /** Produce this Word's hashCode */
    public int hashCode(){
        return this.s.hashCode();
    }
  
    /** Produce a String representation of this Word */
    public String toString(){
        return  s + " has " + freq.toString() + " occurences";
    }
    //increases freq by one
    public void increment(){
    	freq = freq + 1;
    }
    
    public class WordsByFreq implements Comparator<Word>{
    	public WordsByFreq(){}
 
    	public int compare(Word w1, Word w2){
    		if(w1.freq == w2.freq){
    			return 0;
    		}else if(w1.freq < w2.freq){
    			return -1;
    		}else{
    			return 1;
    		}
    	}
    }
}

