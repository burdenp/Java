// Assignment 6 Problem 2
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

// to represent an abstract binary search tree
public abstract class ABST {
  
	// the comparator that determines the tree ordering
	protected ICompareBooks order;
	
	public ABST(ICompareBooks order){
		this.order = order;
	}
	//inserts that node into the correct place in the tree using that order
	public Node insert(Node newNode, ICompareBooks order){
		return new Node(order, new Book(" ", " ", 5), new Leaf(order), new Leaf(order));
	}
	//Returns the first book in a tree
	public Book getFirst(ICompareBooks order){
		return new Book(" ", " ", 5);
	}
	//Checks whether the Leftest item in a tree is a Leaf or Node
	public boolean getFirstHelper(){
		return true;
	}
	//Returns the tree without the first book
	public ABST getRest(ICompareBooks order){
		return new Node(order, new Book(" ", " ", 5), new Leaf(order), new Leaf(order));
	}
	//Compares two books to check if their data is the same
	public boolean sameDataHelper(Book b1){
		return true;
	}
	//Compares two nodes to check if their data is the same
	public boolean sameTree(ABST n1){
		return true;
	}
	public boolean isLeaf(){
		return true;
	}
	public boolean sameData(ABST n1){
		return true;
	}
	public boolean sameAsList(ILoB list){
		return true;
	}
	/*
	 * Template
	 * FIELDS
	 * ...this.order... --ICompareBooks
	 * METHODS:
	 *...this.insert... --- Node
	 *...getFirst... ---Book 
	 *...getFirstHelper ---boolean
	 *getRest    ABST 
	 *sameDataHelper   boolean 
	 *sameTree    boolean 
	 *isLeaf    boolean 
	 * sameData   boolean 
	 * sameAsList   boolean 
	 * METHODS FOR FIELDS:
	 * isBefore... boolean
	 */
}