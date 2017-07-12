package chapter_3;

public class SinglyLinkedList <E> implements Cloneable{

	// Nested Node class
	private static class Node<E>{
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		public E getElement(){
			return element;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setNext(Node<E> n){
			next = n;
		}
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLinkedList(){
		
	}
	
	public int size(){return size;}
	public boolean isEmpty(){return size == 0;}
	public E first(){
		if(isEmpty())
			return null;
		return head.getElement();
	}
	public E last(){
		if(isEmpty())
			return null;
		return tail.getElement();
	}
	
	// Question 9
	public int getSize(){
		if(head == null) return 0;
		int size = 1;
		Node<E> endSeeker = head;
		while(endSeeker.getNext() != null){
			endSeeker = endSeeker.getNext();
			size++;
		}
		return size;
	}
	
	// Question 12
	// Adds the first element to the end of the linked list
	public void rotate(){
		if (head == null || head.getNext() == null) return;
		tail.setNext(head);
		tail = tail.getNext();
		head = head.getNext();
		tail.setNext(null);
	}
	
	public void addFirst(E e){
		head = new Node<>(e, head);
		if(isEmpty())
			tail = head;
		size++;
	}
	
	public void addLast(E e){
		if(isEmpty()){
			head = new Node<>(e, null);
			tail = head;
		}else {
			tail.setNext(new Node<>(e, null));
			tail = tail.getNext();
		}
		size++;
	}
	
	public E removeFirst(){
		if(isEmpty())
			return null;
		E returnValue = head.getElement();
		head = head.getNext();
		size--;
		if(isEmpty()){
			tail = null;
		}
		return returnValue;
		
	}
	
	public boolean equals(Object o){
		if( o == null)return false;
		if(getClass() != o.getClass())return false;
		SinglyLinkedList other = (SinglyLinkedList)o;
		if(size != other.size())return false;
		Node walkA = head;
		Node walkB = other.head;
		while(walkA !=null){
			if(!walkA.getElement().equals(walkB.getElement()))return false;
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}
	
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
		if(size > 0){
			other.head = new Node<>(head.getElement(), null);
			Node<E> walk = head.getNext();
			Node<E> otherTail = other.head;
			while(walk != null){
				Node<E> newest = new Node<>(walk.getElement(),null);
				otherTail.setNext(newest);
				otherTail = newest;
				walk = walk.getNext();
			}
		}
		return other;
	}
}
