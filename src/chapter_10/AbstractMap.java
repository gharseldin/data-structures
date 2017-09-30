package chapter_10;

import java.util.Iterator;

import chapter_9.Entry;

public abstract class AbstractMap<K, V> implements Map<K, V> {
	
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
	
	private class KeyIterator implements Iterator<K>{
		private Iterator<Entry<K,V>> entries = entrySet().iterator();
		public boolean hasNext(){return entries.hasNext();}
		public K next(){return entries.next().getKey();}
		public void remove() {throw new UnsupportedOperationException();}
	}
	
	private class KeyIterable implements Iterable<K>{
		 public Iterator<K> iterator(){
			 return new KeyIterator();
		 }
	}
	
	public Iterable<K> keySet(){
		return new KeyIterable();
	}
	
	private class ValueIterator implements Iterator<V>{
		private Iterator<Entry<K,V>> entries = entrySet().iterator();
		public boolean hasNext(){return entries.hasNext();}
		public V next(){return entries.next().getValue();}
		public void remove(){throw new UnsupportedOperationException();}
	}
	
	private class ValueIterable implements Iterable<V>{
		public Iterator<V> iterator(){
			return new ValueIterator();
		}
	}
	
	public Iterable<V> values(){
		return new ValueIterable();
	}
	
	public boolean isEmpty(){
		return size()==0;
	}	
}
