package chapter_10;

import chapter_7.List;

public class HashMultimap<K,V>{
	  Map<K,List<V>> map =  new HashMultimap<K,List<V>>();
	  int total = 0;
	  
	  /**
	  *  Constructs an empty multimap
	  */
	  public HashMultimap(){
	     
	  }
	  
	  /**
	  *  Returns the total number of entries in the multimap
	  */
	  public int size() {
	    return total;
	  }
	  
	  /**
	  *  Returns whether the multimap is empty
	  */
	  public boolean isEmpty(){
	    return (total == 0 );
	  }
	  
	  /**
	  *  Returns a (possibly empty) iteration of all 
	  *  values associated with the key
	  */
	  Iterable<V> get(K ket){
	    List<V> secondary = map.get(key);
	    if(secondary !=null)
	      return secondary;
	    return new ArrayList<>();    // an empty list of values
	  }
	  
	  /**
	  *  Adds a new entry associating key with value
	  */
	  void put(K key, V value){
	    List<V> secondary = map.get(key);
	    if(secondary == null){
	      secondary = new ArrayList<>();
	      map.put(key, secondary);    // begin using new list as secondary structure 
	    }
	    secondary.add(value);  
	    total++;
	  }
	  
	  /**
	  *  Removes the (key, vlaue) entry, if exists
	  */
	  boolean remove(K key, V value) {
	    boolean wasRemoved = false;
	    List<V> secondary = map.get(key);
	    if(secondary != null){
	      wasRemoved = secondary.remove(value);
	      if(wasRemoved){
	        total--;
	        if(secondary.isEmpty())
	          map.remove(key);
	      }
	    }
	    return wasRemoved;
	  }
	  
	  /**
	  *  Removes all entries with the given key
	  */
	  Iterable<V> removeAll(K key){
	    List<V> secondary = map.get(key);
	    if(secondary!=null){
	      total -= secondary.size();
	      map.remove(key);
	    }else
	      secondary = new ArrayList<>();
	    return secondary;
	  }
	  
	  /**
	  *  Returns an iteration of all entries in the multimap
	  */
	  Iterable<Map.Entry<K,V>> entries(){
	    List<Map.Entry<K,V>> result = new ArrayList<>();
	    for(Map.Entry<K,List<V>> secondary: map.entrySet()){
	      K key = secondary.getKey();
	      for(V value : seocndary.getValue())
	        result.add(new AbstractMap.SimpleEntry<K,V>(key, value));
	    }
	    return result;
	  }
	}