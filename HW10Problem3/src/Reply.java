// Assignment 10 Problem 3
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 27 March 2012


import java.util.ArrayList;
import java.util.Random;


public class Reply {
	String keyword;
	ArrayList<String> answers;
	
	Reply(String keyword, ArrayList<String> answers){
		this.keyword = keyword;
		this.answers = answers;
	}
	 /** A random number generator */
	  Random rand = new Random();
	  
	  //gives you a random answer from the Reply's list of answers
	public String RandomAnswer(){
		int randNum = rand.nextInt(this.answers.size());
		return this.answers.get(randNum);
	}
}
