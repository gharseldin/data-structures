package chapter_2;

public class CreativityQuestions {
	
	// Question 16
	
	// Question 17
	private static void testUnreachable(){
		boolean a = true;
		int count = 0;
		while(a){
			count++;
			if(count >10){
				System.out.println("Exiting now at " + count);
				return;
			}
		}
		System.out.println("This statement is unreachable");
	}
	
	// Question 18
	/**
	 * Done in PredatoryCreditCard class
	 */
	
	// Question 19
	/**
	 * Done in PredatoryCreditCard class
	 */
	
	// Question 20
	/**
	 * Done in PredatoryCreditCard class
	 */
	
	// Question 21
	static class A {
		int x = 10;
	}
	
	static class B extends A{
		int x = 20;
		
		public int getXFromA(){
			return super.x;
		}
		
		public void setXForA(int x){
			super.x = x;
		}
		
	}
	
	static class C extends B{
		int x = 30;
		
		public int getXFromA(){
			return super.getXFromA();
		}
		
		public void setXForA(int x){
			super.setXForA(x);
		}
	}
	
	// question 22
	/**
	 * Because JAVA does not allow for cyclic inheritance
	 */
	
	// Question 23
	/**
	 * Done in FibonacciPrpgression class
	 */
	
	// Question 24
	/**
	 * Done in DifferenceProgression class
	 */
	
	// Question 25
	/**
	 * Done in Progression class partially to be completed.
	 */
	
	// Question 26
	/**
	 * Done in SquareRootProgression class.
	 */
	
	// Question 27
	/**
	 * Done in FibonacciPrpgression class
	 */
	
	// Question 28
	//TODO
	
	// Question 29
	
	
	public static void main(String[] args){
		// Question 17
		// testUnreachable();
		
		// Question 21
//		C c = new CreativityQuestions.C();
//		System.out.println(c.x);
//		System.out.println(c.getXFromA());
//		c.setXForA(1000);
//		System.out.println(c.getXFromA());
		
		// Question 24
//		DifferenceProgression prog = new DifferenceProgression(10, 29);
//		for (int i=0; i<20; i++)
//			System.out.println(prog.nextValue());
		
		// Question 26
//		SquareRootProgression testProgression = new SquareRootProgression();
//		for(int i=0; i<10; i++)
//			System.out.println(testProgression.nextValue());

		
	}
}
