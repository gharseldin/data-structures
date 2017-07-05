package chapter_2;

import java.math.BigInteger;

public class ReinforcementQuestions {
	
	
	// Question 1
	/**
	 * 1 - Aviation software
	 * 2 - Medical software
	 * 3 - Military software
	 */
	
	// Question 2
	/**
	 * Stock market analysis and techniques software
	 */
	
	// Question 3
	/**
	 * 1 - Bold text
	 * 2 - highlight text
	 * 3 - autoComplete 
	 */
	
	// Question 4
	/**
	 * Not sure! Seems to be working fine
	 * 
	 */
	
	// Question 5
	/**
	 * Not sure! Seems to be working fine
	 * 
	 */
	
	// Question 6
	public static BigInteger eighthFibonacciValue(){
		FibonacciProgression prog = new FibonacciProgression(BigInteger.valueOf(2), BigInteger.valueOf(2));
		BigInteger result = BigInteger.ZERO;
		for(int i=0; i<8; i++){
			result = prog.nextValue();
			System.out.println(result);
		}
		return result;
	}
	
	// Question 7
	public static void checkLongOverflow(){
		long max = Long.MAX_VALUE;
		long repetitions = max/128;
		System.out.println(repetitions);
	}
	
	// Question 8
//	public interface interface1 extends interface2{
//		public void someMethod1();
//	}
//	
//	public interface interface2 extends interface1{
//		public void someMethod2();
//	}
	/**
	 * Will not work. Cycle there
	 */
	
	// Question 9
	/**
	 * Dynamic dispatch of methods at Runtime could take a little while to find
	 * the correct method
	 */
	
	// Question 10
	/**
	 * maybe not enough code reuse
	 * maybe not optimal polymorphism 
	 */
	
	// Question 11
	/**
	 * Done in Maryland class
	 */
	
	// Question 12
	// Question 13
	/**
	 * Done on paper
	 */
	
	// Question 14
	public static void indexOutOfBoundTest(){
		int[] test = new int[5];
		try{
			int outOfbounds = test[5];
		}catch (IndexOutOfBoundsException e){
			System.out.println("Don’t try buffer overflow attacks in Java!");
		}
	}
	
	public static void main(String args[]){
		
		// Question 6
		eighthFibonacciValue();
		
		// Question 7
		// checkLongOverflow();
		
		// Question 14
		// indexOutOfBoundTest();
		
		
	}
}
