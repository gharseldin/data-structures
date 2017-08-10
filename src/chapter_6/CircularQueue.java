package chapter_6;

public interface CircularQueue<E> extends Queue<E> {
	
	/**
	 * Rotates the front element of the queue to the back fo the queue
	 * This does nothing if the queue is empty
	 */
	void rotate();
}
