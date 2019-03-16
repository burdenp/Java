
public class BookTitle implements ITransform{
	public BookTitle(){}
	public Object transform(ITransform t){
		return t.transform(this);
	}
}
