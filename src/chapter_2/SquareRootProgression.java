package chapter_2;

public class SquareRootProgression extends Progression<Double>{
	
	public SquareRootProgression(){
		current = 65536D;
	}
	
	public SquareRootProgression(Double startValue){
		current = startValue;
	}
	
	protected void advance(){
		current = Math.sqrt(current);
	}
	
}
