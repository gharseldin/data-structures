package chapter_2;

import java.math.BigInteger;

public class TestProgression {
	
	public static void main(String args[]){
		Progression prog;
		
		System.out.println("Arithmetic progression with default increment: ");
		prog = new ArithmeticProgression();
		prog.printProgression(10);
		System.out.println("Arithmetic progression with increment 5: ");
		prog = new ArithmeticProgression(5);
		prog.printProgression(10);
		System.out.println("Arithmetic progression with start 2: ");
		prog = new ArithmeticProgression(5, 2);
		prog.printProgression(10);
		
		System.out.println("Geometric progression with default base: ");
		prog = new GeometricProgression();
		prog.printProgression(10);
		System.out.println("Geometric progression with base 3: ");
		prog = new GeometricProgression(3);
		prog.printProgression(10);
		System.out.println("Fibonacci progression with default start values: ");
		prog = new FibonacciProgression();
		prog.printProgression(10);
		System.out.println("Fibonacci progression with start values 4 and 6: ");
		prog = new FibonacciProgression(BigInteger.valueOf(4),BigInteger.valueOf(6));
		prog.printProgression(8);		
	}
}
