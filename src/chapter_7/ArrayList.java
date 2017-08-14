package chapter_7;

public class ArrayList<E> implements List<E> {
	
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
