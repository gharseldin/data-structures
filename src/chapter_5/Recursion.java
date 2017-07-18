package chapter_5;

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
	
	public static void main(String[] args){
		drawRuler(3, 4);
	}
}
