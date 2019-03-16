import tester.*;

// CS 2510 Spring 2012
// Program to use for Lab 3
// Author: Viera K. Proulx
// Date: 20 January 2012

// Student pair 050:
// joshs
// pburden

// to represent a time of day in hours and minutes
class ClockTime{
	int minutes;  // must be in the range [0, 24)
	int hours;    // must be in the range [0, 60)
	
	ClockTime(int hours, int minutes){
		this.hours = hours;
		this.minutes = minutes;
	}
	
  /* TEMPLATE
   * FIELDS:
   * ... this.hours ...         -- int
   * ... this.minutes ...       -- int
   * METHODS:
   * ... this.toMinutes() ...   -- int
   * ... this.isBefore() ... -- boolean
   */
	
	// convert the time on this clock to total minutes since midnight
	public int toMinutes(){
		return this.hours*60 + this.minutes;
	}
	//checks if the time is before the given time
	public boolean isBefore(ClockTime time){
		return this.toMinutes() <= time.toMinutes();
	}
}

// to represent an event in a calendar
class Event{
	String name;
	ClockTime startTime;
	ClockTime endTime;
	
	Event(String name, ClockTime startTime, ClockTime endTime){
		this.startTime = startTime;
    this.endTime = endTime;
	}
	
	/* TEMPLATE
	 * FIELDS:
	 * ... this.name ...                    -- String
	 * ... this.startTime ...               -- ClockTime
     * ... this.endTime ...                 -- ClockTime
	 * METHODS:
	 * ... this.duration() ...              -- int
	 * ... this.endsBefore()...             -- boolean
	 * ... this.overlapHuh()...             -- boolean
	 * METHODS FOR FIELDS:
	 * ... this.startTime.toMinutes() ...   -- int
     * ... this.endTime.toMinutes() ...     -- int
	 */	
	
	// compute the duration of this event in minutes
	public int duration(){
	  return this.endTime.toMinutes() - this.startTime.toMinutes();
	}
	//checks if the event ends before the given event starts
	public boolean endsBefore(Event event){
		return this.endTime.isBefore(event.startTime);
	}
	//checks to see if the events overlap each other
	public boolean overlaphuh(Event that){
		return !(this.endsBefore(that) && 
				this.startTime.toMinutes() < that.startTime.toMinutes()||
				that.endsBefore(this) &&
				that.startTime.toMinutes() < this.startTime.toMinutes());
	}
	
}

// to represent events scheduled for one day
interface ISchedule{
  
  // compute the total scheduled time for this day
  public int scheduledTime();
  public boolean goodScheduleHuh();
}

class NoEvents implements ISchedule{
  NoEvents(){}
  
  // compute the total scheduled time for this day
  public int scheduledTime(){
    return 0;
  }
  public boolean goodScheduleHuh(){
	return true;  
  }
}

class ConsEvents implements ISchedule{
  Event first;
  ISchedule rest;
  
  ConsEvents(Event first, ISchedule rest){
    this.first = first;
    this.rest = rest;
  }

  /* TEMPLATE
   * FIELDS:
   * ... this.first ...                   -- Event
   * ... this.rest ...                    -- ISchedule
   * METHODS:
   * ... this.scheduledTime() ...         -- int
   * ... this.goodScheduleHuh()...		  -- boolean
   * METHODS FOR FIELDS:
   * ... this.first.duration() ...       -- int
   * ... this.rest.scheduledTime() ...    -- int
   */ 
  
  // compute the total scheduled time for this day
  public int scheduledTime(){
    return this.first.duration() + this.rest.scheduledTime();
  }
}

class ExamplesCalendar{
  ExamplesCalendar(){}
  
  ClockTime tenAM = new ClockTime(10, 0);
  ClockTime eleven30 = new ClockTime(11, 30);
  ClockTime midnight = new ClockTime(0,0);
  ClockTime noon = new ClockTime (12, 0);
  ClockTime breakfastEnd = new ClockTime (10, 30);
  
  Event fundies2 = new Event("Fundies 2", this.tenAM, this.eleven30);
  Event wakeUp	= new Event("Wake up", this.tenAM, tenAM); 
  Event breakfast1 = new Event("Breakfast", this.tenAM, breakfastEnd);
  

  
  ISchedule allFree = new NoEvents();
  ISchedule onlyFundies2 = new ConsEvents(this.fundies2, this.allFree);
  ISchedule breakfast = new ConsEvents(this.breakfast1, this.allFree);
  ISchedule morning = new ConsEvents(this.wakeUp, this.breakfast);
  
  // test the method toMinutes in the class ClockTime
  boolean testToMinutes(Tester t){
    return
    t.checkExpect(this.tenAM.toMinutes(), 600) &&
    t.checkExpect(this.eleven30.toMinutes(), 690) &&
    t.checkExpect(this.breakfastEnd.toMinutes(), 630);
  }  
  
  // test the method duration in the class Event
  boolean testDuration(Tester t){
    return
    t.checkExpect(this.fundies2.duration(), 90 )&&
    t.checkExpect(this.breakfast1.duration(), 30);
  }  
  
  // test the method scheduledTime in the union of classes ISchedule
  boolean testScheduledTime(Tester t){
    return
    t.checkExpect(this.allFree.scheduledTime(), 0) &&
    t.checkExpect(this.onlyFundies2.scheduledTime(), 90) &&
    t.checkExpect(this.morning.scheduledTime(), 30);
  }
  boolean testIsBefore(Tester t){
	  return
	  t.checkExpect(this.noon.isBefore(this.tenAM), false) &&
	  t.checkExpect(this.tenAM.isBefore(this.noon), true);
  }
  boolean testEndsBefore(Tester t){
	  return
	  t.checkExpect(this.fundies2.endsBefore(this.breakfast1), false);
  }
  boolean overlapHuh(Tester t){
	  return
	  t.checkExpect(this.fundies2.overlaphuh(breakfast1), true);
  }
}

/*
              +-----------+
              | ISchedule |<---------------+
              +-----------+                |
                   / \                     |
                   ---                     |
                    |                      |
       -------------------------           |
       |                        |          |
 +----------+          +----------------+  | 
 | NoEvents |          | ConsEvents     |  |
 +----------+          +----------------+  | 
 +----------+       +--| Event first    |  |
                    |  | ISchedule rest |--+
                    |  +----------------+
                    v
       +---------------------+
       | Event               |
       +---------------------+
       | String name         |
       | ClockTime startTime |----+
       | ClockTime endTime   |--+ |
       +---------------------+  | |
                                | |
                                v v
                         +-------------+
                         | ClockTime   |
                         +-------------+
                         | int hours   |
                         | int minutes |
                         +-------------+
*/
