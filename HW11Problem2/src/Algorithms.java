
// Assignment 11 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username Seydi
// 2 April 2012



import java.util.ArrayList;
import java.util.PriorityQueue;


public class Algorithms {

	//returns an arrayList of LFs with letters
	//and the number of times they occur based on the text given
    public ArrayList<LF> computeHisto (String text){
    	ArrayList<LF> histogram = new ArrayList<LF>();
    	
        for(int index = 0; index < text.length(); index = index +1){
        	LF temp = new LF(text.valueOf(text.charAt(index)), 0);
        	temp.addFrequency(text);
        	if(! histogram.contains(temp)){
        		histogram.add(temp);
        	}
        }
        return this.removeDuplicates(histogram);
    }
    //helper to remove any duplicates from the array list
    public ArrayList<LF> removeDuplicates(ArrayList<LF> list){
    	
    	for(int index = 0; index < list.size(); index = index + 1){
    		LF temp = list.get(index);
    		list.remove(index);
    		if(! list.contains(temp)){
    			list.add(index, temp);
    		}else{
    			index = index - 1;
    			}
    	}
    	return list;
    }
    
    //encodes the string based on Huffman's pattern
    public String encodeString(KeyTree kt, String s){
    	String temp = "";
    	for(int index = 0; index < s.length(); index = index +1){
    		temp = temp + kt.findPath(s.charAt(index));
    		temp = temp.substring(0, temp.length() - 1);
    	}
    	return temp;
    }
    // insert the frequency data into a priority queue
    // produce an priority queue of KeyTree data
    public PriorityQueue<KeyTree> buildPQ(ArrayList< LF> lfList){
       PriorityQueue< KeyTree> pq =
            new PriorityQueue< KeyTree>(lfList.size(), new ByFreq());    
       for(LF lf : lfList){
           pq.offer(new Leaf(lf.letter, lf.frequency));
       }   
       return pq;
    }
    //creates a KeyTree using the PQ to give it the order
    public KeyTree buildTree(PriorityQueue<KeyTree> pq){
    	if(pq.isEmpty()){
    		throw new RuntimeException("there is no PQ");
    	}else while(pq.size() > 1){
    		KeyTree temp1 = pq.poll();
    		KeyTree temp2 = pq.poll();
    		Node temp3 = new Node(temp1, temp2);
    		pq.add(temp3);
    	}
    	return pq.poll();
    }
}
