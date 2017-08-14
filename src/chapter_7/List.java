package chapter_7;

public interface List<E> {

	/**
	 * Returns the number of elements in this list
	 */
	int size();
	
	/**
	 * Returns whether the list is empty
	 */
	boolean isEmpty();
	
	/**
	 * Returns (but does not remove) the element at index i
	 */
	E get(int i) throws IndexOutOfBoundsException;
	
	/**
	 * Inserts element e to be at index i, shifting all subsequent elements later
	 */
	void add(int i, E e) throws IndexOutOfBoundsException;
	
	/**
	 * Removes/returns the element at index i, shifting subsequent elements earlier
	 */
	E remove(int i) throws IndexOutOfBoundsException;
}
