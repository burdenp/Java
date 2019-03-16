// Assignment 6 Problem 2
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

public class Node extends ABST{
	  Book Data;
	  ABST left;
	  ABST right;
	  ICompareBooks order;
	  
	  Node(ICompareBooks order, Book Data, ABST left, ABST right){
	    super(order);
	    this.Data = Data;
	    this.left = left;
	    this.right = right;
	  }
//inserts that node into the correct place in the tree using that order
	public Node insert(Node newNode, ICompareBooks order){
		if(order.isBefore(this.Data, newNode.Data)){
				return new Node(order, this.Data, this.left.insert(newNode, order), this.right);
		} else {
			return new Node(order, newNode.Data, this.left.insert(this, order), this.right);
		}
	}
	//Checks whether the Leftest item in a tree is a Leaf or Node
	public boolean getFirstHelper(){
		return false;
	}
	//Returns the first book in a tree
	public Book getFirst(ICompareBooks order){
		if (this.left.getFirstHelper()){
			return this.Data;
		} else {
			return this.left.getFirst(order);
		}
	}
	//Returns the tree without the first book
	public ABST getRest(ICompareBooks order){
		if (this.left.getFirstHelper()){
			return new Leaf(order);
		} else {
			return new Node(order, this.Data, this.left.getRest(order), this.right);
		}
	}
	//Compares two books to check if their data is the same
	public boolean sameDataHelper(Book b1){
		return (this.Data.title.equals(b1.title)) &&
				(this.Data.author.equals(b1.author)) &&
						(this.Data.price == (b1.price));
	}
	//Compares two nodes to check if their data is the same
	public boolean sameTree(ABST n1){
		if(this.getFirst(order).sameDataHelper(n1.getFirst(order))){
			return this.getRest(order).sameTree(n1.getRest(order));
		} else{
			return false;
		}
	}
	public boolean isLeaf(){
		return false;
	}
	public boolean sameData(ABST n1){
		if(this.inTree(n1)){
			return this.getRest(order).sameData(n1);
		}else{
			return false;
		}
	}
	public boolean inTree(ABST n1){
		if(this.getFirst(order).sameDataHelper(n1.getFirst(order))){
			return true;
		}else{
			return this.inTree(n1.getRest(order));
		}
	}
//puts the list in order and then sees 	if the binary tree and the list are the
//same they are the same if they hold the same book information.
	public boolean sameAsList(ILoB list){
		if(list.sort(order).listHelper(this.getFirst(order))){
			return list.sameList(this.getRest(order));
		}else{
			return false;
		}
	}
	/* TEMPLATE:
	FIELDS:
	order ---ICompareBooks
Data 	Book 
left 	 ABST 
right 	  ABST 
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