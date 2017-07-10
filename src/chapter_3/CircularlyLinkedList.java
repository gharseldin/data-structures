package chapter_3;

public class CircularlyLinkedList<E>{
	
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
		
		private Node<E> tail = null;
		private int size = 0;
		public CircularlyLinkedList(){}
		
		public int size(){ return size;}
		public boolean isEmpty(){ return size == 0;}
		public E first(){
			if(isEmpty()) return null;
			return tail.getNext().getElement();
		}
		public E last(){
			if(isEmpty())return null;
			return tail.getElement();
		}
		public void rotate(){
			if(tail != null)
			tail = tail.getNext();
		}
		public void addFirst(E e){
			if(isEmpty()){
				tail = new Node<>(e,null);
				tail.setNext(tail);
			}
			tail.setNext(new Node<>(e, tail.getNext()));
			size++;
		}
		public void addLast(E e){
			addFirst(e);
			rotate();
		}
		public E removeFirst(){
			if(isEmpty())return null;
			Node<E> startValue = tail.getNext();
			if(startValue == tail )tail = null;
			else
				tail.setNext(startValue.getNext());
			size--;
			return  startValue.getElement();
		}
		
}
