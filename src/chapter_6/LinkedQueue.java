package chapter_6;

import chapter_3.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E> {
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	public LinkedQueue() {}
	public int size(){return list.getSize();}
	public boolean isEmpty(){return list.isEmpty();}
	public void enqueue(E e){list.addLast(e);}
	public E first(){return list.first();}
	public E dequeue(){return list.removeFirst();}
}
