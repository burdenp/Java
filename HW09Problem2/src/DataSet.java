// Assignment 9 Problem 2
// Partner Patrick Burden
// partner1username pburden
// Partner Seydi Sy
// partner2username seydi
// 20 March 2012
/**
 * An interface that represents a data set
 * where we can add and remove items
 *
 * @param  the type of data items in this data set
 */
interface DataSet<T>{

  /**
   * Add the given item to this data set
   * 
   * @param t the given data item
   */
  public void add(T t);

  /**
   * EFFECT: remove an item from this data set
   * 
   * @return the item that has been removed
   * @throws a RuntimeException if this data set is empty
   */
  public T remove();

  /**
   * Produce the number of items in this queue
   * @return the the number of items in this data set
   */
  public int size();
  
  /**
   * Produce the 'next to be removed' item in this data set
   * @return the desired item
   */
  public T current();
}