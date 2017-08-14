package chapter_7;

public interface Position<E> {

	/**
	 * A method that returns the element at this specific position
	 * 
	 * @return The stored element
	 * @throws IllegalStateException if position no longer valid
	 */
	E getElement() throws IllegalStateException;
}
