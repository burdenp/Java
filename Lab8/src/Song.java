
// Represents a song
public class Song implements IValue, MakeString, ITransform{
    String title;
    String artist;
    Integer duration;  // in seconds
    
    public Song(String title, String artist, Integer duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    
    /* Template
     *   Fields
     *     ... this.title ...       -- String
     *     ... this.artist ...      -- String
     *     ... this.duration ...    -- int
     *
     *   Methods 
     *     ... this.value() ...       -- int
     *     ... this.makeString() ...  -- String
     */
    
    // Compute the value of this Song, i.e., its duration
    public int value(){
        return this.duration;
    }
    public String makeString(){
    	return "Song: ".concat(this.title.concat(" by ").concat(this.artist)
    			.concat("\nduration: ").concat(this.duration.toString().concat(" minutes")));
    }
    public Object transform(ITransform T){
    	return this.duration < 200;
    }
}