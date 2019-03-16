// Assignment 8 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

// a method to decide whether this item 
// has the desired property
interface ISelect< T>{
     // does this data item have the desired property?
      public boolean select(T data);
      /* Template
       *   Fields
       *   Methods 
       *     ... this.select(T data) ...       -- boolean
       */
   }

// select only the books that are cheaper than the given limit
class CheapBook implements ISelect<Book>{
  int limit;
  
  CheapBook(int limit){
    this.limit = limit;
  }
  
  public boolean select(Book b){
    return b.price < this.limit;
  }
  /* Template
   *   Fields
   *   ... this.limit.....      --int
   *   Methods 
   *     ... this.select(Book b) ...       -- boolean
   */
}
class ShortSong implements ISelect<Song>{
	ShortSong(){
	}
	public boolean select(Song s){
	    return s.duration < 200;
	  }
	 /* Template
	   *   Fields
	   *   Methods 
	   *     ... this.select(Song s) ...       -- boolean
	   */
}
class ImageJpeg implements ISelect<Image>{
	ImageJpeg(){
	}
	public boolean select(Image i){
	    return i.fileType.equals("Jpeg");
	  }
	 /* Template
	   *   Fields
	   *   Methods 
	   *     ... this.select(Image i) ...       -- boolean
	   */
}