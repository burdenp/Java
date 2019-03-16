// Assignment 8 Problem 3
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012
public interface IBT<T> {
	public <S> S accept(IBTVisitor<T, S> v);
}
