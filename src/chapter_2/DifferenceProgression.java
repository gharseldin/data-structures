package chapter_2;

public class DifferenceProgression extends Progression<Long>{

	protected long prev;
	
	public DifferenceProgression(){
		prev = 2;
		current = 200L;
	}
	
	public DifferenceProgression(long prev, long current){
		this.prev = prev;
		this.current = current;
	}
	
	protected void advance(){
		long temp = prev;
		prev = current;
		current = Math.abs(current - temp);
	}
}
