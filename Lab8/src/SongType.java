
public class SongType implements ITransform{
	public SongType(){}
	public Object transform(ITransform t){
		return t.transform(this);
	}
}
