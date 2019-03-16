
public class ImageSize implements ITransform{
	public ImageSize(){}
	public Object transform(ITransform t){
		return t.transform(this);
	}
		
}
