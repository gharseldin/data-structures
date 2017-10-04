package chapter_11;

import chapter_7.Position;
import chapter_8.LinkedBinaryTree;
import chapter_9.Entry;

public class BalanceableBinaryTree<K,V> extends LinkedBinaryTree<Entry<K,V>>{

	protected static class BSTNode<E> extends Node<E>{
		int aux = 0;
		BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild){
			super(e, parent, leftChild, rightChild);
		}
		
		public int getAux(){return aux;}
		public void setAux(int value) { aux = value;}
	}
	
	public int getAux(Position<Entry<K,V>> p){
		return ((BSTNode<Entry<K,V>>)p).getAux();
	}
	
	public void setAux(Position<Entry<K,V>> p, int value){
		((BSTNode<Entry<K,V>>)p).setAux(value);
	}
	
	protected Node<Entry<K,V>> createNode(Entry<K,V> e, Node<Entry<K,V>> parent,
			Node<Entry<K,V>> left, Node<Entry<K,V>> right){
		return new BSTNode<Entry<K,V>>(e, parent, left, right);
	}
	
	private void relink(Node<Entry<K,V>> parent, Node<Entry<K,V>> child, boolean makeLeftChild){
		child.setParent(parent);
		if(makeLeftChild)
			parent.setLeft(child);
		else
			parent.setRight(child);
	}
	
	public void rotate(Position<Entry<K,V>> p){
		Node<Entry<K,V>> x = validate(p);
		Node<Entry<K,V>> y = x.getParent();
		Node<Entry<K,V>> z = y.getParent();
		
		if(z==null){
			root = x;
			x.setParent(null);
		}else
		relink(z,x, y == z.getLeft());
		// now we rotate
		// if x is on y's left
		if( x == y.getLeft()){
			relink(y, x.getRight(), true);
			relink(x, y, false);
		}
		// x is on y's right
		else {
			relink(y, x.getLeft(), false);
			relink(x, y, true);
		}
	}
	
	// the returned value is the new subtree root
	public Position<Entry<K,V>> restructure(Position<Entry<K,V>> x){
		Position<Entry<K,V>> y = parent(x);
		Position<Entry<K,V>> z = parent(y);
		if((x == right(y)) == (y == right(z))){
			rotate(y);
			return y;
		} else {
			rotate(x);
			rotate(x);
			return x;
		}
	}
	
	
}
