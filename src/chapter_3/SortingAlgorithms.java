package chapter_3;
import java.util.Arrays;

public class SortingAlgorithms {

	// Utility printing method
	public static void print(int[] data){
		for (int i=0; i<data.length; i++){
			if(i == data.length-1)
				System.out.print(data[i]);
			else
				System.out.print(data[i] + ", ");
		}
		System.out.println();
	}
	
	// Insertion sort algorithm
	public static void insertionSort(int[] data){
		for (int i=0; i< data.length; i++){
			for(int j=i ; j>0; j--){
				int temp = data[j];
				if(data[j-1]>data[j]){
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		}
	}
	

	public static void main(String[] args){
		int[] data = {14, 2, 31, 4, 10, 100, -1, 0, -111};
		print(data);
		insertionSort(data);
		print(data);
		System.out.println(Arrays.toString(data));
	}
}
