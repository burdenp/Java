// Assignment 10 Problem 3
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username seydi
// 27 March 2012

import java.util.ArrayList;


public class Eliza {
	ArrayList<Reply> list;
	
	Eliza(ArrayList<Reply> list){
		this.list = list;
	}
	//returns the first word of the given string in lower case
	public String firstWord(String str){
		str = str.toLowerCase();
		str= str.trim();
		 if(str.startsWith("where")){
			 return "where";
		 }else if(str.length() == 3){
			 return str.substring(0, 3).trim();
		 }else{
			 return str.substring(0, 4).trim();
		 }
	}
}
