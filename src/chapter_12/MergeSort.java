package chapter_12;

import java.util.Arrays;
import java.util.Comparator;

import chapter_6.LinkedQueue;
import chapter_6.Queue;

public class MergeSort {

	public static <K> void mergeSort(K[] S, Comparator<K> comp){
		int n = S.length;
		if(n < 2) return;
		
		int mid = n/2;
		K[] S1 = Arrays.copyOfRange(S, 0, mid);
		K[] S2 = Arrays.copyOfRange(S, mid, n);
		
		mergeSort(S1, comp);
		mergeSort(S2, comp);
		
		merge(S1, S2, S, comp);
	}
	
	public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp){
		int i = 0;
		int j = 0;
		while(i+j < S.length){
			if(j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j])<0))
				S[i+j] = S1[i++];
			else{
				S[i+j] = S2[j++];
			}
		}
	}
	
	public static <K> void mergeSort(Queue<K> S, Comparator<K> comp){
		int n = S.size();
		if(n<2)
			return;
		int mid = n/2;
		Queue<K> S1 = new LinkedQueue<>();
		Queue<K> S2 = new LinkedQueue<>();
		
		for(int i=0; i<mid; i++){
			S1.enqueue(S.dequeue());
		}
		while(!S.isEmpty())
			S2.enqueue(S.dequeue());
		
		mergeSort(S1, comp);
		mergeSort(S2, comp);
		
		merge(S1, S2, S, comp);
		
	}
	
	public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp){
		while(!S1.isEmpty() && !S2.isEmpty()){
			if(comp.compare(S1.first(), S2.first())<0)
				S.enqueue(S1.dequeue());
			else
				S.enqueue(S2.dequeue());
		}
		
		while(!S1.isEmpty())
			S.enqueue(S1.dequeue());
		while(!S2.isEmpty())
			S.enqueue(S2.dequeue());
	}
	
	
	public static void main(String[] args){
		
	}
}
