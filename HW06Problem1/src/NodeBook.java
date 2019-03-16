// Assignment 6 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Patrick Burden
// partner2username PBurden
// 20 February 2012

// a class to represent a node in a binary search tree
public class NodeBook extends ABSTBook{
	Book data;
	ABSTBook left;
	ABSTBook right;

	NodeBook(Book data, ABSTBook left, ABSTBook right){
		super(left.comp);
		this.data = data;
		this.left = left;
		this.right = right;
	}
	/*
	 * Template
	 * FIELDS
	 * ... this.comp... --ICompareBooks
	 * ...this.book... --Book
	 * ...this.left.. --ABSTBook
	 * ...this.right... --ABSTBook
	 * METHODS:
	 * METHODS FOR FIELDS:
	 */
}