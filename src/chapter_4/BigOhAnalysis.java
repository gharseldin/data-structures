package chapter_4;

import java.util.Arrays;

public class BigOhAnalysis {
	
	public static String repeat1(char c, int n){
		String answer = "";
		for (int i = 0; i< n; i++)
			answer += c;
		return answer;
	}
	
	public static String repeat2(char c, int n){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n ; i++)
			sb.append(c);
		return sb.toString();
	}
	
	// Worst case of O(n)
	public static double arrayMax(double[] data){
		int n = data.length;
		double currentMax = data[0];
		for ( int i=1; i<n; i++){
			if(currentMax< data[i])
				currentMax = data[i];
		}
		return currentMax;
	}
	
	// Worst case of O(n^3)
	public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC){
		for(int a: groupA)
			for(int b: groupB)
				for(int c: groupC)
					if((a==b)&&(b==c))
						return false;
		return true;
	}
	
	// An improvement
	// If a and b are not equal then its a waste of time to iterate over c
	// Worst case of O(n^2) assuming that there are no duplicates within a single set
	public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC){
		for(int a: groupA)
			for (int b: groupB)
				if(a == b)
					for(int c: groupC)
						if(a == c)
							return true;
		return false;
									
	}
	
	// Worst case of O(n^2)
	public static boolean unique1(int[] data){
		int n = data.length;
		for(int j=0; j<n-1; j++)
			for (int k=j+1; k<n; k++)
				if(data[j] == data [k])
					return false;
		return true;
	}
	
	// if we sort the array in the uniqueness problem first we can then improve on the time
	public static boolean unique2(int[] data){
		int n = data.length;
		int[] temp = Arrays.copyOf(data, n);
		Arrays.sort(temp);
		for(int i = 0; i<n-1; i++)
			if(temp[i] == temp[i+1])
				return false;
		return true;
	}
	
	// Worst case of O(n^2)
	public static double[] prefixAverage1(double[] x){
		int n = x.length;
		double[] a  = new double[n];
		for(int i=0; i<n; i++){
			double total = 0;
			for(int j=0; j<=i; j++)
				total +=x[j];
			a[i] = total/(i+1);
		}
		return a;
	}
	
	// We can improve on the prefixAverage algorithm by maintaining the sum value 
	// and not computing it from scratch each and every time.
	// Worst case of O(n)
	public static double[] prefixAverage2(double[] x){
		int n = x.length;
		double []a = new double[n];
		double total = 0;
		for(int i=0; i<n; i++){
			total += x[i];
			a[i] = total/(i+1);
		}
		return a;
	}
	
}
