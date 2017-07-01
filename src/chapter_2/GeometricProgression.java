package chapter_2;

public class GeometricProgression extends Progression{
	
	protected long base;
	
	public GeometricProgression(){
		this(1,2);
	}
	
	public GeometricProgression(long base){
		this(base, 1);
	}
	
	public GeometricProgression(long base, long start){
		super(start);
		this.base = base;
	}
	
	protected void advance(){
		current *= base;
	}
}
