package chapter_2;

public class ArithmaticProgression extends Progression{
	
	protected long increment;
	
	public ArithmaticProgression(){
		this(1,0);
	}
	
	public ArithmaticProgression(long stepSize){
		this(stepSize, 0);
	}
	
	public ArithmaticProgression(long stepSize, long start){
		super(start);
		increment = stepSize;
	}
	
	protected void advance(){
		current +=increment;
	}
}
