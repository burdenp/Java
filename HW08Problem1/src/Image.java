// Assignment 8 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

// Represent an Image file
public class Image implements IValue, MakeString{
    String title;
    String fileType;
    Integer fileSize;  // in bytes
    
    public Image(String title, String fileType, Integer fileSize){
        this.title = title;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }
    
    /* Template
     *   Fields
     *     ... this.title ...       -- String
     *     ... this.fileType ...    -- String
     *     ... this.fileSize ...    -- int
     *
     *   Methods 
     *     ... this.value() ...       -- int
     *     ... this.makeString() ...  -- String
     */
    
    // Compute the value of this Image, i.e., its fileSize
    public int value(){
        return this.fileSize;
    }
    public String makeString(){
    	return "Image: ".concat(this.title.concat(".").concat(this.fileType)
    			.concat("\nsize: ").concat(this.fileSize.toString().concat("MB")));
    }
}