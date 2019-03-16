import tester.*;
import java.util.*;

/**
 * to represent a nonempty list of objects
 */
class WrapAL<T> implements Traversal<T>{

  /** the ArrayList we wish to traverse over */
  private ArrayList<T> arrlist;
  
  /** the currently first item in the ArrayList */
  private int first;

  /**
   * Public constructor for the <code>ArrayList</code> we wish to traverse
   * 
   * @param arrlist the <code>ArrayList</code> we wish to traverse
   */
  public WrapAL(ArrayList<T> arrlist){
    if (arrlist == null) 
      throw new IllegalUseOfTraversalException(
      		"Cannot traverse a null ArrayList");
    this.arrlist = arrlist;
    this.first = 0;
  }
  
  /**
   * Private constructor to produce the <code>Traversal</code> for the 
   * rest of the <code>ArrayList</code> we are currently traversing
   * 
   * @param arrlist the <code>ArrayList</code> we are currently traversing
   * @param first the index for the first element to view in the given
   * <code>ArrayList</code>
   */
  private WrapAL(ArrayList<T> arrlist, int first){
    this.arrlist = arrlist;
    this.first = first;
  }
  

  /**
   * Is this an empty list?
   */
  public boolean isEmpty(){ 
    return this.first == this.arrlist.size();
  }  

  /**
   * Produce the first item in this list
   */
  public T getFirst(){
    if (this.isEmpty())
      throw new IllegalUseOfTraversalException(
      		"No first element in an empty list");
    return this.arrlist.get(this.first);
  }

  /** 
   * Produce a <code>Traversal</code> for the rest of this list
   */
  public Traversal<T> getRest(){
    if (this.isEmpty())
      throw new IllegalUseOfTraversalException(
      		"No more elements in an empty list");
    return new WrapAL<T>(this.arrlist, this.first + 1);
  }
} 
