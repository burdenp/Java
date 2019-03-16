// Assignment 8 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

public class SongType implements ITransform<Song, Boolean>{
	public SongType(){}
	public Boolean transform(Song t){
		return t.duration < 200;
	}
	 /* Template
	   *   Fields
	   *   Methods 
	   *     ... this.transform(Song t) ...       -- boolean
	   */
}
