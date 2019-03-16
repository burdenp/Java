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
   * ... this.isBefore(ClockTime)- boolean
   */
	
	// convert the time on this clock to total minutes since midnight
	public int toMinutes(){
		return this.hours * 60 + this.minutes;
	}
	
	public boolean isBefore(ClockTime that){
		return this.toMinutes() <= that.toMinutes();
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
	 * ... this.endsBefore(Event) ...       -- boolean
	 * ... this.overlapHuh(Event) ...       -- boolean
	 * METHODS FOR FIELDS:
	 * ... this.startTime.toMinutes() ...   -- int
     * ... this.endTime.toMinutes() ...     -- int
	 */	
	
	// compute the duration of this event in minutes
	public int duration(){
	  return this.endTime.toMinutes() - this.startTime.toMinutes();
	}
	
	// check if one event ends before the other starts
	public boolean endsBefore(Event that){
		return this.endTime.isBefore(that.startTime);
	}
	
	// check if two events overlap
	public boolean overlapHuh(Event that){
	  return !(this.endsBefore(that) && 
			  this.startTime.toMinutes() < that.startTime.toMinutes()
			  
			  ||
			  
			  that.endsBefore(this) && 
			  that.startTime.toMinutes() < this.startTime.toMinutes());
	}
	
}

// to represent events scheduled for one day
interface ISchedule{
  
  // compute the total scheduled time for this day
  public int scheduledTime();
  
  //checks whether the events are in order and do not overlap
  public boolean goodScheduleHuh();
  
  public Event getEvent();
}

class NoEvents implements ISchedule{
  NoEvents(){}
  
  // compute the total scheduled time for this day
  public int scheduledTime(){
    return 0;
  }
  
  //checks whether the events are in order and do not overlap
  public boolean goodScheduleHuh(){
	return true;
  }
  
  public Event getEvent(){
	return new Event("end", new ClockTime(24,0), new ClockTime(24,0));
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
   * ... this.goodScheduleHuh() ...       -- boolean
   * METHODS FOR FIELDS:
   * ... this.first.duration() ...       -- int
   * ... this.rest.scheduledTime() ...    -- int
   * ... this.endsBefore(Event) ...       -- boolean
   * ... this.overlapHuh(Event) ...       -- boolean
   */ 
  
  // compute the total scheduled time for this day
  public int scheduledTime(){
    return this.first.duration() + this.rest.scheduledTime();
  }
  
  public Event getEvent(){
	return this.first;
  }
  
  //checks whether the events are in order and do not overlap
  public boolean goodScheduleHuh(){
	return this.first.overlapHuh(this.rest.getEvent()) && 
			this.first.endsBefore(this.rest.getEvent()) &&
			this.rest.goodScheduleHuh();
  }
}








class ExamplesCalendar{
  ExamplesCalendar(){}
  
  ClockTime tenAM = new ClockTime(10, 0);
  ClockTime eleven30 = new ClockTime(11, 30);
  ClockTime eleven = new ClockTime(11,0);
  ClockTime partyStart = new ClockTime(0,0);
  ClockTime partyEnd = new ClockTime(4,0);
  ClockTime wakeUp = new ClockTime(12, 40);
  ClockTime breakfastEnd = new ClockTime(13,30);
  
  Event fundies2 = new Event("Fundies 2", this.tenAM, this.eleven30);
  Event party = new Event("Party", this.partyStart, this.partyEnd);
  Event morning = new Event("Morning", this.wakeUp, this.breakfastEnd);
  Event overlapping = new Event("Overlap Tester", this.eleven, this.wakeUp);
  Event allDay = new Event("All day", this.partyStart, this.breakfastEnd);
  
  ISchedule allFree = new NoEvents();
  ISchedule onlyFundies2 = new ConsEvents(this.fundies2, this.allFree);
  ISchedule lateNight = new ConsEvents(this.party, this.allFree);
  ISchedule nightToDay = new ConsEvents(this.morning, this.lateNight);
  ISchedule dayToNight = new ConsEvents(this.party, onlyFundies2);
  ISchedule overlap = new ConsEvents(this.overlapping, onlyFundies2);
  
  // test the method toMinutes in the class ClockTime
  boolean testToMinutes(Tester t){
    return
    t.checkExpect(this.tenAM.toMinutes(), 600) &&
    t.checkExpect(this.eleven30.toMinutes(), 690) &&
    t.checkExpect(this.wakeUp.toMinutes(), 760);    
  }  
  
  // test the method duration in the class Event
  boolean testDuration(Tester t){
    return
    t.checkExpect(this.fundies2.duration(), 90) &&
    t.checkExpect(this.morning.duration(), 50);    
  }  
  
  // test the method scheduledTime in the union of classes ISchedule
  boolean testScheduledTime(Tester t){
    return
    t.checkExpect(this.allFree.scheduledTime(), 0) &&
    t.checkExpect(this.onlyFundies2.scheduledTime(), 90) &&
    t.checkExpect(this.nightToDay.scheduledTime(), 290);   
  }
  
  // test the method isBefore in the class ClockTime
  boolean testIsBefore(Tester t){
	  return
	  t.checkExpect(this.tenAM.isBefore(eleven30), true) &&
	  t.checkExpect(this.partyEnd.isBefore(partyStart), false) &&
	  t.checkExpect(this.wakeUp.isBefore(wakeUp), true);
  }
  
  //test the method endsBefore in the class Event
  boolean testEndsBefore(Tester t){
	  return
	  t.checkExpect(this.fundies2.endsBefore(this.morning), true) &&
	  t.checkExpect(this.morning.endsBefore(this.fundies2), false) &&
	  t.checkExpect(this.morning.endsBefore(this.morning), false);
  }
  
  //test the method overlapHuh in the class Event
  boolean testOverlapHuh(Tester t){
	  return
      t.checkExpect(this.fundies2.overlapHuh(allDay), true) &&
      t.checkExpect(this.allDay.overlapHuh(fundies2), true) &&
      t.checkExpect(this.fundies2.overlapHuh(overlapping), true) &&
      t.checkExpect(this.overlapping.overlapHuh(fundies2), true) &&
      t.checkExpect(this.party.overlapHuh(fundies2), false) &&
      t.checkExpect(this.fundies2.overlapHuh(party), false);
  }
  
  //test the method goodScheduleHuh
  boolean testGoodScheduleHuh(Tester t){
	  return
	  t.checkExpect(this.allFree.goodScheduleHuh(), true) &&
	  t.checkExpect(this.nightToDay.goodScheduleHuh(), false) &&
	  t.checkExpect(this.dayToNight.goodScheduleHuh(), true) &&
 	  t.checkExpect(this.overlap.goodScheduleHuh(), false);
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
