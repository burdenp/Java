// Assignment 11 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Name2 Seydi Sy
// partner2username Seydi
// 2 April 2012


// to represent a Huffman Tree
abstract class KeyTree{
	// the frequency of this character or collection
	int freq;

	KeyTree(int freq){
		this.freq = freq;
	}
	//Finds the binary path to the given character
	public String findPath(Character cha){
		return cha.toString();
	}
	//sees if the KeyTree contains the given character
	public boolean contains(Character cha){
		return false;
	}
	//returns the next letter in the KeyTree using the binary paths
	public String nextLetter(String s){
		return s;
	}
	//decodes a string from binary to letters
	public String decode(String s){
		return s;
	}
	//helper for decode it moves through the tree finding the letters
	public String whichString(String s, KeyTree kt){
		return s;
	}
}

// to represent a single character
class Leaf extends KeyTree{
	String letter;

	Leaf(String letter, int freq){
		super(freq);
		this.letter = letter;
	}
	//Finds the binary path to the given character
	public String findPath(Character cha){
		return cha.toString();
	}
	//sees if the KeyTree contains the given character
	public boolean contains(Character cha){
		return this.letter.equals(cha.toString());
	}
	//returns the next letter in the KeyTree using the binary paths
	public String nextLetter(String s){
		if(s.equals("")){
			return letter;
		}else{
			throw new RuntimeException("Invalid Path");
		}
	}
	//decodes a string from binary to letters
	public String decode(String s){
		if(s.equals("")){
			return this.letter;
		}else{
			throw new RuntimeException("Invalid path");
		}
	}
	//helper for decode it moves through the tree finding the letters
	public String whichString(String s, KeyTree kt){
		if(s.equals("")){
			return letter;
		}else{
			return letter + kt.whichString(s, kt);
		}
	}
}
// to represent a splitting node in the KeyTree
class Node extends KeyTree{
	KeyTree left;
	KeyTree right;

	Node(KeyTree left, KeyTree right){
		super(left.freq + right.freq);
		this.left = left;
		this.right = right;
	}
	//Finds the binary path to the given character
	public String findPath(Character cha){
		if(left.contains(cha)){
			return "0" + left.findPath(cha);
		}else if(right.contains(cha)){
			return "1" + right.findPath(cha);
		}else{
			throw new RuntimeException("Character is not in the tree");
		}
	}
	//sees if the KeyTree contains the given character
	public boolean contains(Character cha){
		return right.contains(cha) || left.contains(cha);
	}
	//returns the next letter in the KeyTree using the binary paths
	public String nextLetter(String s){
		if(s.startsWith("0")){
			return this.left.nextLetter(s.substring(1, s.length()));
		}else if(s.startsWith("1")){
			return this.right.nextLetter(s.substring(1, s.length()));
		}else{
			throw new RuntimeException ("Invalid Path");
		}
	}
	//decodes a string from binary to letters
	public String decode(String s){
		return this.whichString(s, this);
	}
	//helper for decode it moves through the tree finding the letters
	public String whichString(String s, KeyTree kt){
		if(s.startsWith("0")){
			return this.left.whichString(s.substring(1, s.length()), kt);
		}else if(s.startsWith("1")){
			return this.right.whichString(s.substring(1, s.length()), kt);
		}else{
			throw new RuntimeException ("Invalid Path");
		}
	}
	
}
  
  
  
  