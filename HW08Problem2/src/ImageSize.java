// Assignment 8 Problem 2
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

//copied code from problem one that inclueds answer to problem 2
//since they are both from the same lab and use
//all the same classes

public class ImageSize implements ITransform<Image, Integer>{
	public ImageSize(){}
	public Integer transform(Image t){
		return t.fileSize;
	}
	/* Template
     *   Fields
     *   Methods 
     *     ... this.transform(Image t) ...       -- Image
     */
}
