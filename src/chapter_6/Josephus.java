package chapter_6;

public class Josephus {

	public static <E> E Josephus(CircularQueue<E> queue, int k){
		if(queue.isEmpty())return null;
		while(queue.size() > 1){
			for(int i=0; i<k; i++)
				queue.rotate();
			E e = queue.dequeue();
			System.out.println("   "+ e +" is out" );
		}
		return queue.dequeue(); //The winner
	}
	
	/**
	 *  a utility method to build a circular queue from an array of objects
	 */
	public static <E> CircularQueue<E> buildQueue(E a[]){
		CircularQueue<E> queue = new LinkedCircularQueue<>();
		for(int i=0; i<a.length; i++)
			queue.enqueue(a[i]);
		return queue;
	}
	
	/**
	 * testing
	 */
	public static void main(String[] args){
		String[] a1 = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
		String[] a2 = {"Gene", "Hope", "Irene", "Jack", "Kim", "Lance"};
		String[] a3 = {"Mike", "Roberto"};
		System.out.println("First winner is " + Josephus(buildQueue(a1), 3));
		System.out.println("Second winner is " + Josephus(buildQueue(a2), 10));
		System.out.println("Third winner is " + Josephus(buildQueue(a3), 7));
	}
}
