package chapter_5;

import java.io.File;

public class Recursion {

	public static int factorial(int n) throws IllegalArgumentException{
		if(n<0) throw new IllegalArgumentException();
		if(n == 0)
			return 1;
		else
			return n * factorial(n-1);
	}
	
	// Methods to draw and English ruler
	public static void drawRuler(int nInches, int majorLength){
		drawLine(majorLength, 0);
		for(int i=1; i<nInches; i++){
			drawInterval(majorLength-1);
			drawLine(majorLength, i);
		}
	}

	// The recursive function
	private static void drawInterval( int centralLength){
		if(centralLength >= 1){
			drawInterval(centralLength -1);
			drawLine(centralLength);
			drawInterval(centralLength-1);
		}
	}
	
	// A utility method to drawing a ticks and a label
	private static void drawLine(int tickLength, int tickLabel){
		for(int i=0; i< tickLength ; i++)
			System.out.print("-");
		if(tickLabel >=0)
			System.out.print(" " + tickLabel);
		System.out.println();
	}
	
	// A utility method to draw a given tick length but no label
	private static void drawLine(int tickLength){
		drawLine(tickLength, -1);
	}
	
	public static boolean binarySearch(int[] data, int target, int low, int high){
		// base case
		if(low > high)
			return false;
		else{
			int mid = (low+high/2);
			if(target == data[mid])
				return true;
			else if(target < data[mid])
				return binarySearch(data, target, low, mid-1);
			else
				return binarySearch(data, target, mid+1, high);
		}
	}
	
	// Calculating the total disk usage in bytes of a portion of 
	// the file system rooted at a given path
	public static long diskUsage(File root){
		long total = root.length();
		if(root.isDirectory()){
			for(String childname : root.list()){
				File child = new File(root, childname);
				total += diskUsage(child);
			}
		}
		System.out.println(total + "\t" + root);
		return total;
	}
	
	public static int linearSum(int[] data, int n){
		if(n == 0)
			return 0;
		return data[n-1] + linearSum(data, n-1);
	}
	
	
	public static void reverseArray(int[] data, int low, int high){
		if(low<high){
			int temp = data[low];
			data[low] = data[high];
			data[high] = temp;
			reverseArray(data, low+1, high-1);
		}
	}
	
	public static double power(double x, int n){
		if( n==0 ) return 1;
		return x*power(x, n-1);
	}
	
	public static double power2(double x, int n){
		if( n== 0 )return 1;
		else{
			double partial = power2(x, n/2);
			double result = partial * partial;
			if( n%2 == 1)
				result *= x;
			return result;
		}
	}
	
	public static int binarySum(int[] data, int low, int high){
		if(low>high) return 0;
		if(low == high) return data[low];
		int mid = (low + high)/2;
		return binarySum(data, low, mid) + binarySum(data, mid+1, high);
	}
	
	// A not very efficient way of implementing the uniqueness problem
	// returns true if there are no duplicate values from data[low] through data[high]
	// O(2^n) !!
	public static boolean unique3(int[] data, int low, int high){
		if(low >= high) return true;
		if(!unique3(data, low, high-1)) return false;
		if(!unique3(data, low+1, high)) return false;
		else return (data[low] != data[high]);
	}
	
	// A not very efficient way of implementing a Fibonacci recursive method
	// exponential time O (2^n/2) !!
	public static long fibonacciBad(int n){
		if(n <= 1)
			return n;
		return fibonacciBad(n-2) + fibonacciBad(n-1);
	}
	
	// A better way to compute a Fibonnacci number
	// runs in O(n) time
	public static long[] fibonacciGood(int n){
		if(n<=1){
			long[] answer = {n,0};
			return answer;
		} else{
			long[] temp = fibonacciGood(n-1);
			long[] answer = {temp[0] + temp[1], temp[0]};
			return answer;
		}
	}
	
	// Converting a trail recursion into an iterative one.
	public static boolean binarySearchIterative(int[] data, int target){
		int low = 0;
		int high = data.length-1;
		while(low <= high){
			int mid = (low + high)/2;
			if(target == data[mid])
				return true;
			else if (target < data[mid])
				high = mid-1;
			else
				low = mid+1;
		}
		return false;
	}
	
	// non recursive method to reverse the contents of an array
	public static void reverseIterative(int[] data){
		int low = 0, high = data.length - 1;
		while(low < high){
			int temp = data[low];
			data[low++] = data[high];
			data[high--] = temp;
		}
	}
	
	public static void main(String[] args){
		drawRuler(3, 4);
	}
}
