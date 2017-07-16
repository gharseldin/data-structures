package chapter_3;

import java.util.Arrays;
import java.util.Random;

public class ReinforcementQuestions {

	// Question 1
	private static int[] generatePseudorandomNumbers(int number){
		// next = (a * cur + b) % n;
		int[] results = new int[number+1];
		results[0] = 92;
		for(int i=1; i<results.length; i++){
			results[i] = (12 * results[i-1] + 5)%100; 
		}
		return Arrays.copyOfRange(results, 1, results.length);
	}
	
	// Question 2
	private static <T> void randomSelectAndRemove(T[] data){
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		while(arrayHasValues(data)){
			int randomNumber = rand.nextInt(data.length);
			if(data[randomNumber]!=null){
				T temp = data[randomNumber];
				data[randomNumber] = null;
				System.out.println("Value : " + temp + " removed");
				System.out.println(Arrays.toString(data));
			}else{
				System.out.println("Previously removed value field selected");
			}
		}
	}
	
	// Question 3
	/**
	 * We will have to change the number of characters (26 in case of English)
	 * Make sure if we need the isUpper() method. Not needed in some languages 
	 */
	
	// Question 4
	// Done in TicTacToe class
	
	// Question 5
	// Nothing would happen. We are just freeing resources by setting the tail to null
	
	// Question 6
	/**
	 * if isEmpty or seize equal to 1 return null
	 * Node beforeLast = head;
	 * while( beforeLast.next.next != null)
	 * 	beforeLast = beforeLast.next
	 * 
	 * return beforeLast
	 */
	
	// Question 7
	// Done in CircularlyLinkedList class
	
	
	// Question 8
	/**
	 * 
	 * Node middleSeeker = head
	 * Node endSeeker = head
	 * 
	 * if(size = 0) return null
	 * if(size = 1) return head
	 * if(size = 2) return head
	 * 
	 * while (endSeeker.next != null || endSeeker.next.next != null)
	 * 		middleSeeker = middleSeeker.next
	 * 		endSeeker = endSeeker.next.next
	 * 
	 * return middleSeeker
	 * 
	 * 
	 */
	
	// Question 9
	// Done in SinglyLinkedList class
	
	// Question 10
	// Done in CircularlyLinkedList class
	
	// Question 11
	// Done in DoublyLinkedList class
	
	// Question 12
	// Done in SinglyLinkedList class
	
	// Question 13
	/**
	 * There is no difference in a shallow equality test and a deep equality test
	 * between two one dimensional int arrays
	 * 
	 * There is still no difference because arrays are not true class types and
	 * if two arrays are of the same size and have the same equivalent value of 
	 * primitives in their indices then both will be equal 
	 */
	
	// Question 14
	// int[] backup = original.clone();
	// Arrays.copyOf(original, original.length)
	// Arrays.copyOfRange(original, 0, original.length)
	
	// Question 15
	// Done in CircularlyLinkedList class
	
	// Question 16
	// Done in DoublyLinkedList class
	private static <T> boolean arrayHasValues(T[] data){
		for (int i=0; i< data.length; i++){
			if(data[i]!=null)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		
		// Question 1
		// System.out.println(Arrays.toString(generatePseudorandomNumbers(5)));
		
		// Quesiton 2
		// Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		// randomSelectAndRemove(input);
		
		// Question 3
		// explained
	}
}
