
public interface IVisitorBT<T, R> {

	// Visitor method for leafs
	public R forLeaf();
	
	// Visitor methods for nodes
	public R forNode(T val, IBT<T> left, IBT<T> right);
}

class SumBT implements IVisitorBT<Integer, Integer> {
	
	public Integer forLeaf() {
		return 0;
	}
	
	public Integer forNode(Integer val, 
			IBT<Integer> left,
			IBT<Integer> right) {
		
		return val + left.accept(this) + right.accept(this);
	}
	
}
