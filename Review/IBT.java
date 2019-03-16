
public interface IBT<T> {

	public <R> R accept(IVisitorBT<T, R> visitor);
	
}

class Leaf<T> implements IBT<T> {
	
	public <R> R accept(IVisitorBT<T, R> visitor) {
		return visitor.forLeaf();
	}

}

class Node<T> implements IBT<T> {
	T val;
	IBT<T> left;
	IBT<T> right;
	
	public Node(T val, IBT<T> left, IBT<T> right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public <R> R accept(IVisitorBT<T, R> visitor) {
		return visitor.forNode(this.val, this.left, this.right);
	}
	
}