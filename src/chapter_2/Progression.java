package chapter_2;

public abstract class Progression <T extends Number> {
	
	protected T current;
	
	public Progression(){
		this((T) new Long(0));
	}
	
	public Progression(T start){
		current = start;
	}
	
	public T nextValue(){
		T answer = current;
		advance();
		return answer;
	}
	
	protected abstract void advance();
	
	public void printProgression(int n){
		System.out.print(nextValue());
		for(int j=1; j<n; j++)
			System.out.print(" " + nextValue());
		System.out.println();
	}
}
