package chapter_10;

import java.util.Comparator;

import chapter_10.AbstractMap.MapEntry;

public abstract class AbstractSortedMap<K, V> implements SortedMap<K,V> {

	private Comparator<K> comp;
	
	private static class DefaultComparator<K> implements Comparator<K>{
		public int compare(K a, K b){
			return ((Comparable<K>)a).compareTo(b);
		}
	}
	
	protected AbstractSortedMap(Comparator<K> c){
		comp = c;
	}
	
	protected AbstractSortedMap(){
		this(new DefaultComparator<K>());
	}
	
	protected int compare(K key, MapEntry<K,V> b){
		return comp.compare(key, b.getKey());
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
}
