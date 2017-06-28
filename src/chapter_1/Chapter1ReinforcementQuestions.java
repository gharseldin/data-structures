package chapter_1;

import java.util.Scanner;

public class Chapter1ReinforcementQuestions {

	// Questions 1
	public static void inputAllBaseTypes(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a boolean value");
		boolean enteredBoolean = input.nextBoolean();
		System.out.println("Enter a character");
		String enteredString = input.next();
		System.out.println("Enter a byte");
		byte enteredByte = input.nextByte();
		System.out.println("Enter a short");
		short enteredShort = input.nextShort();
		System.out.println("Enter an integer");
		int enteredInteger = input.nextInt();
		System.out.println("Enter a Long");
		long enteredLong = input.nextLong();
		System.out.println("Enter a float");
		float enteredFloat = input.nextFloat();
		System.out.println("Enter a Double");
		double enteredDouble = input.nextDouble();
		
		System.out.println("boolean:\t" + enteredBoolean +
				"\nString:\t\t" + enteredString +
				"\nByte:\t\t" + enteredByte +
				"\nShort:\t\t" + enteredShort +
				"\nInteger:\t" + enteredInteger +
				"\nLong:\t\t" + enteredLong +
				"\nFloat:\t\t" + enteredFloat +
				"\nDouble:t\t" + enteredDouble);
		
		input.close();
	}
	
	// Question2
	// The value will be = 550 since the references are to objects
	
	// Question 3
	public static boolean isMultiple(long n, long m){
		return n%m == 0;
	}
	
	// Question 4
	public static boolean isEven(int i){
		String iString = i+"";
		char d = iString.charAt(iString.length()-1);
		if( d == '0' || d == '2' || d == '4' || d == '6' || d == '8'  ){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isEvenBitWise(int i){
		return (i & 1) == 0;
		
	}

	// Question 5
	public static int sumToN(int n){
		int sum = 0;
		for (int i = 1; i<=n; i++){
			sum+=i;
		}
		return sum;
	}
	
	// Question 6
	public static int sumOddToN(int n){
		int sum = 0;
		for (int i = 1; i<=n; i+=2){
			sum+=i;
		}
		return sum;
	}
	
	// Question 7
	public static int sumSquareToN(int n){
		int sum = 0;
		for (int i=1; i<=n; i++){
			sum+=i*i;
		}
		return sum;
	}
	
	// Question 8
	public static int vowels(String sentence){
		int vowels = 0;
		for (int i=0; i<sentence.length(); i++){
			char a = sentence.toLowerCase().charAt(i);
			if( a == 'a' || a == 'o' || a == 'i' || a == 'u' || a == 'e'){
				vowels++;
			}
		}
		return vowels;
	}
	
	// Question 9
	public static String removePunctuation(String sentence){
		String noPunctuationSentence = "";
		for (int i=0; i<sentence.length(); i++){
			if((sentence.charAt(i)+"").matches("\\d|\\w|\\s+")){
				noPunctuationSentence+=sentence.charAt(i);
			}
		}
		return noPunctuationSentence;
	}
	
	// Question 10
	private class Flower{
		String name;
		int noOfPetals;
		float price;
		
		Flower(String name, int noOfPetals, float price){
			this.name = name;
			this.noOfPetals = noOfPetals;
			this.price = price;
		}
		
		public String getName(){
			return name;
		}
		
		public int getNoOfPetals(){
			return noOfPetals;
		}
		
		public float getPrice(){
			return price;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public void setNoOfPetals(int noOfPetals){
			this.noOfPetals = noOfPetals;
		}
		
		public void setPrice(float price){
			this.price = price;
		}
	}

	// Question 11
	
	
	public static void main (String[] args){
		// Question 1
		// inputAllBaseTypes();
		
		// Question 3
		// System.out.println(isMultiple(12, 5));
		
		// Question 4
		// System.out.println(isEven(23325));
		// System.out.println(isEvenBitWise(551));
		
		// Question 5
		// System.out.println(sumToN(11));
		
		// Question 6
		// System.out.println(sumOddToN(11));
		
		// Question 7
		// System.out.println(sumSquareToN(4));
		
		// Question 8
		// System.out.println(vowels("This should have 7 vowels"));
		
		// Question 9
		// System.out.println(removePunctuation("This isn't a lot of 2 punctuations."));
		
		// Question 10
		
	}
}
