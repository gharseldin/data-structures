package chapter_2;

import java.math.BigInteger;

public class FibonacciProgression extends Progression<BigInteger>{

	protected BigInteger prev;
	
	public FibonacciProgression(){
		this(BigInteger.ZERO, BigInteger.ONE);
	}
	
	public FibonacciProgression(BigInteger first, BigInteger second){
		super(first);
		prev = second.add(first.negate());
	}
	
	protected void advance(){
		
		current = current.add(prev);
		prev = current.add(prev.negate());
	
	}
}
