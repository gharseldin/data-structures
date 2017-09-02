package chapter_8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import chapter_6.LinkedQueue;
import chapter_6.Queue;
import chapter_7.Position;

public abstract class AbstractTree<E> implements Tree<E> {
	
	public boolean isInternal(Position<E> p){return numChildren(p) > 0;}
	public boolean isExternal(Position<E> p){return numChildren(p) == 0;}
	public boolean isRoot(Position<E> p){return p == root();}
	public boolean isEmpty(){return size() == 0;}
	
	public int depth(Position<E> p){
		if(isRoot(p))
			return 0;
		else
			return 1 + depth(parent(p));
	}
	
	/**
	 * This is a bad way to calculate the height. It will run in O(n^2)
	 */
	public int heightBad() {
		int h = 0;
		for(Position<E> p : positions())
			if(isExternal(p))
				h = Math.max(h,  depth(p));
		return h;
	}
	
	/**
	 * a better way to calculate height in O(n) of a subtree at position p
	 */
	public int height(Position<E> p){
		int h = 0;
		for(Position<E> c : children(p))
			h = Math.max(h,  1 + height(c));
		return h;
	}
	
	//------------Nested element Iterator class --------------------------
	/**
	 * This class adapts the iteration produced by positions to return elements
	 */
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> posIterator = positions().iterator();
		public boolean hasNext() { return posIterator.hasNext();}
		public E next() { return posIterator.next().getElement();}
		public void remove() { posIterator.remove();}
	}
	
	public Iterator<E> iterator() { return new ElementIterator();}
	
	public Iterable<Position<E>> positions() {return preorder();}
	
	
	// pre-order traversal
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
		snapshot.add(p);
		for(Position<E> c: children(p)){
			preorderSubtree(c, snapshot);
		}
	}
	
	public Iterable<Position<E>> preorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			preorderSubtree(root(), snapshot);
		return snapshot;
	}
	
	// post-order traversal
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
		for(Position<E> c: children(p))
			postorderSubtree(c, snapshot);
		snapshot.add(p);
	}
	
	public Iterable<Position<E>> postorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty())
			postorderSubtree(root(), snapshot);
		return snapshot;
	}
	
	// breadth first traversal
	public Iterable<Position<E>> breadthfirst(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty()){
			Queue<Position<E>> fringe = new LinkedQueue<>();
			fringe.enqueue(root());
			while(!fringe.isEmpty()){
				Position<E> p = fringe.dequeue();
				snapshot.add(p);
				for (Position<E> c: children(p))
					fringe.enqueue(c);
			}
		}
		return snapshot;
	}

}
