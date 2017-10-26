package chapter_12;

import java.util.Comparator;

import chapter_6.LinkedQueue;
import chapter_6.Queue;

public class QuickSort {
	
	public static <K> void quickSort(Queue<K> S, Comparator<K> comp){
		int n = S.size();
		if(n<2) return;
		
		K pivot = S.first();
		Queue<K> L = new LinkedQueue<>();
		Queue<K> E = new LinkedQueue<>();
		Queue<K> G = new LinkedQueue<>();
		
		while(!S.isEmpty()){
			if(comp.compare(S.first(),pivot) < 0)
				L.enqueue(S.dequeue());
			else if (comp.compare(S.first(),  pivot) > 0)
				G.enqueue(S.dequeue());
			else
				E.enqueue(S.dequeue());
		}
		
		quickSort(L, comp);
		quickSort(G, comp);
		
		while(!L.isEmpty())
			S.enqueue(L.dequeue());
		while(!E.isEmpty())
			S.enqueue(E.dequeue());
		while(!G.isEmpty())
			S.enqueue(G.dequeue());
	}
}
