package chapter_4;

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
}
