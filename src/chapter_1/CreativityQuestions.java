package chapter_1;

import java.util.Scanner;

public class CreativityQuestions {

	// Question 14
	/**
	 * pseudo-code
	 * 
	 * input [1,2,3,4,5]
	 * counter = 0
	 * loop for size of array from upper to lower{
	 *   output[counter] = input[index]
	 *   increment counter by 1
	 * }
	 */
	private static int[] reverse(int[] input){
		int[] output = new int[input.length];
		int counter = 0;
		for (int i=input.length; i>0; i--){
			output[counter] = input[i-1];
			counter++;
		}
		return output;
	}
	
	// Question 15
	/**
	 * pseudo-code
	 * 
	 * assume they are integers
	 * min = maximum int
	 * max = minimum int
	 * loop over array {
	 *   if number bigger than max then assign
	 *   if number smaller than min then assign 
	 * }
	 * 
	 */
	private static int[] minMaxSearch(int[] input){
		int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		for(int i=0; i<input.length; i++){
			if(input[i]<result[0])
				result[0] = input[i];
			if(input[i]>result[1])
				result[1]=input[i];
		}
		return result;
	}
	
	// Question 16
	private static void verifyFormulaCompliance(){
		Scanner inputScanner = new Scanner(System.in);
		int a, b, c;
		System.out.println("Enter a: ");
		a = inputScanner.nextInt();
		System.out.println("Enter b: ");
		b = inputScanner.nextInt();
		System.out.println("Enter c: ");
		c = inputScanner.nextInt();
		
		inputScanner.close();
		
		if(a+b == c)
			System.out.println("a + b = c : true");
		else
			System.out.println("a + b = c : false");
		
		if(b-c == a)
			System.out.println("a = b - c : true");
		else
			System.out.println("a = b - c : false");
		
		if(a*b == c)
			System.out.println("a * b = c : true");
		else
			System.out.println("a * b = c : false");
	}
	
	// Question 17
	private static void evenProductSearch(int[] input){
		for(int i=0; i<input.length; i++){
			for(int j=i+1; j<input.length; j++){
				if((input[i] * input[j])%2 == 0){
					System.out.println("The two numbers that multiply to give an even number are " +
							input[i] + " & " + input[j]);
					return;
				}
			}
		}
		System.out.println("There are no two numbers that when multiplied together would give an even number");
	}
	
	// Question 18
	private static double norm(int[] v, int p){
		Double sumOfSquares = 0.0;
		for(int i=0; i<v.length; i++){
			sumOfSquares+= Math.pow(v[i], p);
		}
		return Math.exp(Math.log(sumOfSquares)/p);
	}
	
	private static double norm(int[] v){
		return Math.sqrt(v[0] * v[0] + v[1] * v[1]);
	}
	
	// Question 19
	private static int divideByTwo(int number){
		int numberOfDivisions =0;
		if(number <=2){
			System.out.println("invalid number");
			return numberOfDivisions;
		}else{
			do{
				number /=2;
				numberOfDivisions++;
			}while(number >= 2);
		}
		return numberOfDivisions;
	}
	
	// Question 20
	private static boolean areAllNumbersDistinct(float[] numbers){
		for(int i=0; i<numbers.length; i++){
			for(int j=i+1; j<numbers.length; j++){
				if(numbers[i] == numbers[j])
					return false;
			}
		}
		return true;
	}
	
	// Question 21
	private static void printArray(int[] numbers){
		for (int i =0; i<numbers.length; i++){
			System.out.print(numbers[i] +", ");
		}
		System.out.println();
	}
	private static int[] shuffleNumebrs(int[] numbers){
		int assignments = 1;
		int[] result = new int[52];
		for(int i=0; i<52; i++){
			result[i] = -1;
		}
		do{
			int randomIndex = (int)Math.round((Math.random() * 51));
			if(result[randomIndex] != -1)
				continue;
			result[randomIndex] = assignments;
			assignments++;
		}while(assignments<53);
		return result;
	}
	
	// Question 22
	private static void printAllPossibleStrings(String characters){

	}
	
	// Question 23
	private static int[] arrayDotProduct(int[] a, int[] b){
		int[] result = new int[a.length];
		for(int i = 0; i<a.length; i++){
			result[i] = a[i]*b[i];
		}
		return result;
	}
	
	// Question 24
	// Answer added to Credit Card class
	
	// Question 25
	// Answer added to Credit Card class
	
	public static void main (String args[]){
		// Question 14
//		int[] input = {15, 17, 19 , 21};
//		int[] output = reverse(input);
//		for (int i =0; i<output.length; i++){
//			System.out.print(output[i] +", ");
//		}
		
		// Question 15
//		int[] input = {10, 20, 35, -19, 100, 9876, -50, 0};
//		int[] output = minMaxSearch(input);
//		System.out.print("Minimum value: "+ output[0] + ", Maximum Value: " + output[1]);

		// Question 16
//		verifyFormulaCompliance();
		
		// Question 17
//		int[] input = {-1, 1, 3, 3, 5, 7, 2};
//		evenProductSearch(input);
		
		// Question 18
//		int[] input = {3,4,5};
//		System.out.println("Euclidean norm of 3 and 4 = " + norm(input,3));
		
		// Question 19
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter a number greater than 2:");
//		System.out.println(divideByTwo(scanner.nextInt()));
		
		// Question 20
//		float[] testCase = {1.1F, 1.2F, 0.2F, 0F, -10F, 1.1F};
//		System.out.print(areAllNumbersDistinct(testCase));
		
		// Question 21
//		int[] numbers = new int[52]; 
//		for(int i=1; i<=52; i++){
//			numbers[i-1] = i;
//		}
//		printArray(numbers);
//		printArray(shuffleNumebrs(numbers));
		
		
		// Question 23
		int[] a = {1, 2, 3, 4, 5, 6};
		int[] b = {5, 5, 5, 5, 5, 5};
		printArray(arrayDotProduct(a, b));
		
		// Question 24
		// Answer added to Credit Card class
		
		// Question 25
		// Answer added to Credit Card class
	}
}
