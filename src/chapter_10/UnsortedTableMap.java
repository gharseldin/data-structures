package chapter_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import chapter_9.Entry;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V>{

	private ArrayList<MapEntry<K,V>> table = new ArrayList<>();
	
	public UnsortedTableMap(){}
	
	private int findIndex(K key){
		int n=table.size();
		for(int i=0; i<n; i++)
			if(table.get(i).getKey().equals(key))
				return i;
		return -1;
	}
	
	@Override
	public int size() {
		return table.size();
	}

	@Override
	public V get(K key) {
		int i = findIndex(key);
		if(i == -1)
			return null;
		else
			return table.get(i).getValue();
	}

	@Override
	public V put(K key, V value) {
		int i = findIndex(key);
		V returnValue;
		if(i == -1){
			table.add(new MapEntry<>(key, value));
			returnValue = null;
		}else{
			returnValue = table.get(i).getValue();
			table.set(i, new MapEntry<>(key, value));
		}
		return returnValue;
	}

	@Override
	public V remove(K key) {
		int i = findIndex(key);
		int n = size();
		if(i == -1)
			return null;
		else{
			V value = table.get(i).getValue();
			if(i != n-1)
				table.set(i, table.get(n-1));
			table.remove(n-1);
			return value;
		}
	}

	class EntryIterable implements Iterable<Entry<K,V>>{
		public Iterator<Entry<K,V>> iterator(){
			return new EntryIterator();
		}
	}
	
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return new EntryIterable();
	}

	private class EntryIterator implements Iterator<Entry<K,V>>{

		private int i = 0;
		
		@Override
		public boolean hasNext() {
			return i == table.size();
		}

		@Override
		public Entry<K, V> next() {
			if(i == table.size()) throw new NoSuchElementException();
			return table.get(i++);
		}
	}
}
