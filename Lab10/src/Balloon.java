/** 
 * A simple class to use for learning about classes and objects. 
 * 
 * @since  30 July 2002
 * @author Viera K. Proulx
 */
import colors.*;


public class Balloon {
  
  /*-------------------------------------------------------------------------
   Member data 
   *-----------------------------------------------------------------------*/
  
  /** center of the balloon */
  public int x;
  public int y;
  
  /** the radius of the balloon */
  public int radius;
  
  /** the color of the balloon */
  public IColor c;
  
  /*-------------------------------------------------------------------------
   Constructor
   *-----------------------------------------------------------------------*/
  
  public Balloon (int some_x, int some_y, int some_radius, IColor some_color){
    this.x = some_x;
    this.y = some_y;
    this.radius = some_radius;
    this.c = some_color;
  }
  
  /*-------------------------------------------------------------------------
   Methods 
   *-----------------------------------------------------------------------*/
   
  /** 
   * Compute the distance of this balloon from the top of window 
   * 
   * @return the distance to the top
   */
  int distanceFromTop(){
    return this.y - this.radius;
  } 
}
