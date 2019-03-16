

// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
public interface IBST<T> extends IBT<T> {
	// Insert given element into this binary search tree.
	// (The resulting tree must be sorted.)
	public IBST<T> insert(T elem);

	// Get the smallest element in this binary search tree.
	// (Raise a run-time exception if there is no such element.)
	public T min();

	// Get the largest element in this binary search tree.
	// (Raise a run-time exception if there is no such element.)
	public T max();
}
