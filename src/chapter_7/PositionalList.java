package chapter_7;

public interface PositionalList<E> {

	/**
	 * a method to return the size of the list
	 * 
	 * @return size of the list
	 */
	int size();
	
	/**
	 * a method to return whether the list is empty or not
	 * 
	 * @return a boolean value representing whether the list is empty or not
	 */
	boolean isEmpty();
	
	Position<E> first();
	Position<E> last();
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	Position<E> addFirst(E e);
	Position<E> addLast(E e);
	
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	E set(Position<E> p , E e) throws IllegalArgumentException;
	E remove(Position<E> p) throws IllegalArgumentException;
}
