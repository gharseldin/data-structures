package chapter_10;

import java.util.Comparator;

import chapter_9.Entry;

public abstract class AbstractSortedMap<K, V> implements SortedMap<K,V> {

	protected static class MapEntry<K, V> implements Entry<K, V>{
		
		private K key;
		private V value;
		
		public MapEntry(K k, V v){
			key = k;
			value = v;
		}
		
		public K getKey(){return key;}
		public V getValue(){return value;}
		
		protected void setKey(K k){key = k;}
		protected V setValue(V v){
			V old  = value;
			value = v;
			return old;
		}
		
	}
	
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
	
	protected int compare(K key, Entry<K,V> b){
		return comp.compare(key, b.getKey());
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	/**
	 * Determines whether a key is valid
	 */
	protected boolean checkKey(K key)throws IllegalArgumentException{
		try{
			return (comp.compare(key,   key) == 0);
		} catch (ClassCastException e){
			throw new IllegalArgumentException("Incompatible key");
		}
	}
}
