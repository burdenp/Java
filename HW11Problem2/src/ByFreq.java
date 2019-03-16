// Assignment 11 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username Seydi
// 2 April 2012

import java.util.Comparator;

public class ByFreq implements Comparator<KeyTree>{
	ByFreq(){}

	//compares the 2 elements
	public int compare(KeyTree t1, KeyTree t2){
		if( t1.freq < t2.freq){
			return 1;
		}else if(t1.freq == t2.freq){
			return 0;
		}else{
			return -1;
		}
	}
}

