package chapter_10;

import java.util.ArrayList;

import chapter_9.Entry;

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
	
	private UnsortedTableMap<K, V>[] table;	// initialized in create table
	public ChainHashMap() { super();}
	public ChainHashMap(int cap) {super(cap);}
	public ChainHashMap(int cap, int p) {super(cap, p);}
	
	// this will create an empty table with length equal to the capacity
	protected void createTable() {
		table = (UnsortedTableMap<K,V>[]) new UnsortedTableMap[capacity];
	}

	protected V bucketGet(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if(bucket == null)
			return null;
		return bucket.get(k);
	}
	
	protected V bucketPut(int h, K k, V v) {
		UnsortedTableMap<K, V> bucket = table[h];
		if(bucket == null)
			bucket = table[h] = new UnsortedTableMap<>();
		int oldSize = bucket.size();
		V answer = bucket.put(k, v);
		n += (bucket.size() - oldSize);
		return answer;
	}
	
	protected V bucketRemove(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if(bucket == null)
			return null;
		int oldSize = bucket.size();
		V answer = bucket.remove(k);
		n -= (oldSize - bucket.size());
		return answer;
	}
	
	public Iterable<Entry<K,V>> entrySet(){
		ArrayList<Entry<K,V>> buffer = new ArrayList<>();
		for(int h=0; h<capacity; h++)
			if(table[h]!=null)
				for(Entry<K,V> entry : table[h].entrySet())
					buffer.add(entry);
		return buffer;
	}
	
	@Override
	public V remove(K key) {
		return null;
	}
}
