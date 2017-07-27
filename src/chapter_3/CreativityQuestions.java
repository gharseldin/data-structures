package chapter_3;

import java.util.Arrays;
import java.util.Random;

public class CreativityQuestions {

	
	// Question 17
	public static int findRepeatedInt(int[] numbers){
		int testingNumber;
		for(int i=0; i< numbers.length-1; i++){
			testingNumber =  numbers[i];
			for(int j=i+1 ; j<numbers.length; j++){
				if(testingNumber == numbers[j])
					return testingNumber;
			}
		}
		return -1;
	}
	
	// Question 18
	public static int[] findFiveRepeatedIntegers(int[] numbers){
		int[] repeatedNumbers = {-1, -1, -1, -1, -1};
		int numbersFoundIndex = 0;
		boolean allValuesFound = false;
		for(int i = 0; i< numbers.length-1; i++){
			
			if (numbersFoundIndex <5) repeatedNumbers[numbersFoundIndex] = numbers[i];
			else{
				allValuesFound = true;
			}
			
			for(int j = i+1; j<numbers.length; j++){
				if(repeatedNumbers[numbersFoundIndex] == numbers[j]){
					numbersFoundIndex++;
					break;
				}
			}
		}
		if (!allValuesFound){
			repeatedNumbers[numbersFoundIndex] = -1;
		}
		return repeatedNumbers;
	}
	
	// Question 19
	// TODO in ScoreBoard class
	
	// Question 20
	// a and b being zero or 1
	
	// Question 21
	// Zero
	
	// Question 22
	public static int[] shuffle(int[] A){
		
		// create random number generator
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		
		// create a new array for shuffled values and initialize with -1
		int[] shuffledA = new int[A.length];
		for (int i=0; i<shuffledA.length; shuffledA[i] = -1, i++);
		
		//generate a random number and place it in the appropiate spot
		int populatedIndices = 0;
		while(populatedIndices < A.length){
			int randomIndex = rand.nextInt(A.length);
			if(shuffledA[randomIndex] == -1){
				shuffledA[randomIndex] = A[populatedIndices];
				populatedIndices++;
			}
		}
		return shuffledA;
	}
	
	
	
	public static void main(String[] args){
	
		// Question 17
		// int[] testData = {1,2, 3, 4, 5};
		// System.out.println(findRepeatedInt(testData));
	
		// Question 18
		// int[] testData = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4, 3, 6, 16};
		// System.out.println(Arrays.toString(findFiveRepeatedIntegers(testData)));
	
		// Question 22
		int[] testData = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		System.out.println(Arrays.toString(shuffle(testData)));
	}
}
