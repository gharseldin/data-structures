package chapter_10;

import java.util.ArrayList;
import java.util.Comparator;

import chapter_10.AbstractMap.MapEntry;
import chapter_9.Entry;

public class SortedTableMap<K, V> extends AbstractSortedMap<K,V> {
	
	private ArrayList<MapEntry<K,V>> table = new ArrayList<>();
	public SortedTableMap(){ super();}
	public SortedTableMap(Comparator<K> comp){ super(comp);}
	
	private int findIndex(K key, int low, int high){
		if(high<low)
			return high+1;
		int mid = (low + high)/2;
		int comp = compare(key, table.get(mid));
		if(comp == 0)
			return mid; 			// found the exact match
		else if (comp < 0)
			return findIndex(key, low, mid -1);
		else
			return findIndex(key, mid + 1, high);
		}
	
	private int findIndex(K key){
		return findIndex(key, 0, table.size()-1);
	}
	
	public int sizse(){
		return table.size();
	}
	
	public V get(K key){
		int j = findIndex(key);
		if(j == size() || compare(key, table.get(j)) != 0)	//this is a not match
			return null;
		return table.get(j).getValue();
	}
	
	public V put(K key, V value){
		int j = findIndex(key);
		if(j < size() && compare(key, table.get(j)) == 0)	// match found and just updateing entry
			return table.get(j).setValue(value);
		table.add(j, new MapEntry<>(key, value));
		return null;
	}
	
	public V remove(K key){
		int j = findIndex(key);
		if(j == size() || compare(key, table.get(j)) != 0)
			return null;
		return table.remove(j).getValue();
	}
	
	/**
	 * Utility returns the entry at index j, or else null if j is out of bounds
	 */
	private Entry<K,V> safeEntry(int j){
		if(j< 0 || j>=table.size())
			return null;
		return table.get(j);
	}
	
	/**
	 * Returns the entry having the least key (or null if map is empty)
	 */
	public Entry<K,V> firstEntry(){
		return safeEntry(0);
	}
	
	public Entry<K,V> lastEntry(){
		return safeEntry(table.size()-1);
	}
	
	public Entry<K,V> ceilingEntry(K key){
		return safeEntry(findIndex(key));
	}
	
	public Entry<K,V> floorEntry(K key){
		int j = findIndex(key);
		if(j==size() ||!key.equals(table.get(j).getKey()))
				j--;
		return safeEntry(j);
	}
	
	public Entry<K,V> lowerEntry(K key){
		return safeEntry(findIndex(key)-1);
	}
	public Entry<K,V> higherEntry(K key){
		int j = findIndex(key);
		if( j<size() && key.equals(table.get(j).getKey()))
			j++;	//go past exact match
		return safeEntry(j);
	}
	private Iterable<Entry<K,V>> snapshot(int startIndex, K stop){
		ArrayList<Entry<K,V>> buffer = new ArrayList<>();
		int j = startIndex;
		while (j<table.size() && (stop == null || compare(stop, table.get(j))>0))
			buffer.add(table.get(j++));
		return buffer;
	}
	
	public Iterable<Entry<K,V>> entrySet() { return snapshot(0, null);}
	public Iterable<Entry<K, V>> subMap(K fromKey, K toKey){
		return snapshot(findIndex(fromKey), toKey);
	}
	@Override
	public int size() {
		return table.size();
	}
	
	@Override
	public Iterable<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}
}
