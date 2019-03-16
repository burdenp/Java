/**
 * Class that implements <CODE>{@link Predicate ISelect}</CODE> to select
 * <CODE>{@link Balloon Balloon}</CODE> with the radius smaller 
 * than the limit provided to the constructor.
 */
public class SmallBalloon implements Predicate<Balloon>{
  /** the limit for the radius */
  int limit;

  /** 
   * Save the desired limit to compare against
   * @param limit the limit for the balloon radius
   */
  SmallBalloon(int limit){
    this.limit = limit;
  }

  /**
   * Is this balloon smaller than the given radius?
   */
  public boolean apply(Balloon balloon){
    return balloon.radius < this.limit;
  }
}
