import tester.*;

/**
 * to represent an empty list of objects
 */
class MTList<T> implements IList<T>{

  MTList(){}

  /**
   * Is this an empty list?
   */
  public boolean isEmpty(){ return true; }  

  /**
   * Produce the first item in this list
   */
  public T getFirst(){
    throw new IllegalUseOfTraversalException("No first element in an empty list");
  }

  /** 
   * Produce a <code>Traversal</code> for the rest of this list
   */
  public Traversal<T> getRest(){
    throw new IllegalUseOfTraversalException("No more elements in an empty list");
  }
}       
