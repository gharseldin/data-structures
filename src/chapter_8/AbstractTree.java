package chapter_8;

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
}
