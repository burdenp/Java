
// Assignment 11 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username Seydi
// 2 April 2012


public class LF {

        String letter;
        int frequency;
        
        LF(String letter, int frequency){
            this.letter = letter;
            this.frequency = frequency;
         }
        //increases the frequency by one, every time the LF's letter
        //appears in the given string
        public void addFrequency(String word){
        	for(int index = 0; index < word.length(); index = index +1){
        		String temp = word.valueOf(word.charAt(index));
        		if(temp.equals(letter)){
        			frequency = frequency + 1;
        		}
        	}
        }
        //a rewrite of the equals function
        public boolean equals(Object obj){
        	LF temp = (LF) obj;
        	return this.letter.equals(temp.letter) && this.frequency == temp.frequency;
        }
 }


