package chapter_7;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	
	//-------------------- nested ArrayIterator class ---------------
	/**
	 * a non-static inner class. each instance contains an implicit
	 * reference to the containing list, allowing it to access the list's
	 * members
	 */
	private class ArrayIterator implements Iterator<E>{
		
		private int j = 0;	//index of the next element to report
		private boolean removable = false;	// can remove be called at this time?
		
		/**
		 * Test whether the iterator has a next object
		 */
		public boolean hasNext(){ return j<size;}
		
		/**
		 * returns the next object in the iterator
		 */
		public E next() throws NoSuchElementException{
			if(j ==size) throw new NoSuchElementException("No next element");
			removable =true;
			return data[j++];
		}
		
		/**
		 * Removes the element returned by most recent call to next
		 */
		public void remove() throws IllegalStateException {
			if(!removable) throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(j-1);
			j--;
			removable = false;
		}
	}	//--------------- end of nested ArrayIterator class --------------
	
	/**
	 * Returns an iterator of the elements stored in the list
	 */
	public Iterator<E> iterator(){
		return new ArrayIterator();
	}
	
	//instance variables
	public static final int CAPACITY=16;
	private E[] data;
	private int size = 0;
	
	//constructors
	public ArrayList(){this(CAPACITY);}
	public ArrayList(int capacity){
		data = (E[]) new Object[capacity];
	}
	//public methods
	/**
	 * Returns the number of elements in the array list
	 */
	public int size(){return size;}
	
	/**
	 * Returns whether the array list is empty
	 */
	public boolean isEmpty(){ return size==0;}
	
	/**
	 * Returns (but does not remove) the element at index i
	 */
	public E get(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		return data[i];
	}
	
	/**
	 * Replaces the element at index i with e, and returns the replaced element
	 */
	public E set(int i, E e) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}
	
	/**
	 * Insert element e to be at index i, shifting all subsequent elements later
	 */
	public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
		checkIndex(i, size+1);
		if(size == data.length)
//			throw new IllegalStateException("Array is full");
			resize(2*data.length);
		for(int k=size-1; k>=i; k--)
			data[k+1] = data[k];
		data[i] = e;
		size++;
	}
	
	/**
	 * Removes/returns the element at index i, shifting subsequent elements earlier
	 */
	public E remove(int i) throws IndexOutOfBoundsException{
		checkIndex(i, size);
		E temp = data[i];
		for (int k=i; k<size-1; k++)
			data[k]= data[k+1];
		data[size-1] = null;
		size--;
		return temp;
	}
	
	//utility method
	/**
	 * checks whether the given index is in the range [0, n-1]
	 */
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
		if(i<0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: "+i);
	}
	
	/**
	 * Resizes internal array to have given capacity >= size
	 */
	protected void resize(int capacity){
		E[] temp = (E[]) new Object[capacity];
		for(int i=0; i<size; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
}
