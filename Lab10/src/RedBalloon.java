import colors.*;

/**
 * Class that implements <CODE>{@link Predicate ISelect}</CODE> to select
 * only red <CODE>{@link Balloon Balloon}</CODE>s.
 */
public class RedBalloon implements Predicate<Balloon>{

  /**
   * Is this a red balloon?
   */
  public boolean apply(Balloon balloon){
    return balloon.c instanceof Red;
  }
}
