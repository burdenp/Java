// Assignment 6 Problem 2
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

public class Leaf extends ABST{
		 ICompareBooks order;

	Leaf(ICompareBooks order){
		 super(order);
	}
//inserts that node into the correct place in the tree using that order
	public Node insert(Node newNode, ICompareBooks order){
		return newNode;
	}
	//Returns the first book in a tree
	public Book getFirst(ICompareBooks order){
		throw new RuntimeException("No First In An Empty Tree");
	}
	//Checks whether the Leftest item in a tree is a Leaf or Node
	public boolean getFirstHelper(){
		return true;
	}
	//Returns the tree without the first book
	public ABST getRest(ICompareBooks order){
		throw new RuntimeException("No Rest Of An Empty Tree");
	}
	//Compares two books to check if their data is the same
	public boolean sameDataHelper(Book b1){
		return false;
	}
	//Compares two nodes to check if their data is the same
	public boolean sameTree(ABST n1){
		if(n1.isLeaf()){
			return true;
		}else{
			return false;
		}
	}
	public boolean isLeaf(){
		return true;
	}
	public boolean sameData(ABST n1){
		return true;
	}
	/* TEMPLATE:
	FIELDS:
	order ---ICompareBooks
	METHODS:
insert 	Node 
getFirstHelper 	boolean 
getRest 	ABST 
sameDataHelper 	boolean 
sameTree 	boolean 
isLeaf 	boolean 
sameData 	boolean 
	METHODS FOR FIELDS:

	*/
}
