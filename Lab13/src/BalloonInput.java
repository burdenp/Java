import java.awt.*;			// to get Color
import edu.neu.ccs.gui.*;	// to get CancelledException

/** 
 * An input interface for a Balloon object 
 * 
 * @since 17 March 2004
 * @author Viera K. Proulx
 */
interface BalloonInput{

  /** demand a Balloon object from some source */
  public Balloon demandBalloon();

  /** request a Balloon object from some source */
  public Balloon requestBalloon() throws CancelledException;

}

