// Assignment 8 Problem 1
// Partner James Kandebo
// partner1username Kandebo
// Partner Name2 Patrick Burden
// partner2username pburden
// 14 March 2012

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
