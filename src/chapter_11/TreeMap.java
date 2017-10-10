package chapter_11;

import java.util.ArrayList;
import java.util.Comparator;

import chapter_10.AbstractSortedMap;
import chapter_7.Position;
import chapter_9.Entry;

public class TreeMap<K,V> extends AbstractSortedMap<K,V>{
	
	protected BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>();
	
	public TreeMap(){
		super();
		tree.addRoot(null);
	}
	
	public TreeMap(Comparator<K> comp){
		super(comp);
		tree.addRoot(null);
	}
	
	public int size(){
		return (tree.size() - 1) / 2;		// to account for sentinels that don't have entries
	}
	
	private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry){
		tree.set(p,  entry);
		tree.addLeft(p, null);
		tree.addRight(p, null);
	}
	
	// a set of protected methods that provide notational shorthands to wrap
	protected Position<Entry<K,V>> root(){
		return tree.root();
	}
	
	protected boolean isRoot(Position<Entry<K,V>> p){
		return tree.isRoot(p);
	}
	
	protected Position<Entry<K,V>> left(Position<Entry<K,V>> p){
		return tree.left(p);
	}
	
	protected Position<Entry<K,V>> right(Position<Entry<K,V>> p){
		return tree.right(p);
	}
	
	protected Position<Entry<K,V>> parent(Position<Entry<K,V>> p){
		return tree.parent(p);
	}
	
	protected boolean isExternal(Position<Entry<K,V>> p){
		return tree.isExternal(p);
	}
	
	protected boolean isInternal(Position<Entry<K,V>> p){
		return tree.isInternal(p);
	}
	
	protected void remove(Position<Entry<K,V>> p){
		tree.remove(p);
	}
	
	protected Position<Entry<K,V>> sibling(Position<Entry<K,V>> p){
		return tree.sibling(p);
	}
	
	protected Position<Entry<K,V>> restructure(Position<Entry<K,V>> p){
		return tree.restructure(p);
	}
	
	protected void rotate(Position<Entry<K,V>> p){
		tree.rotate(p);
	}


	
	private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key){
		if(isExternal(p))
			return p;		// This is a sentinel node saying the search failed.
		int comp = compare(key, p.getElement());
		if(comp == 0)
			return p;		// This is an exact match and we return it
		else if (comp < 0)
			return treeSearch(tree.left(p), key);	// start again recursively from the left side
		else
			return treeSearch(tree.right(p), key);	// start again recursively from the right side
	}
	
	
	// hooks that can be customized later
	protected void rebalanceAccess(Position<Entry<K,V>> p){
		
	}
	
	protected void rebalanceInsert(Position<Entry<K,V>> p){
		
	}
	
	protected void rebalanceDelete(Position<Entry<K,V>> p){
		
	}
	
	
	public V get(K key) throws IllegalArgumentException{
		checkKey(key);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		rebalanceAccess(p);
		if(tree.isExternal(p))return null;
		return p.getElement().getValue();
	}
	
	public V put(K key, V value) throws IllegalArgumentException{
		checkKey(key);
		Entry<K,V> newEntry = new MapEntry<>(key, value);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if(tree.isExternal(p)){
			expandExternal(p, newEntry);
			rebalanceInsert(p);
			return null;
		}else{
			V old = p.getElement().getValue();
			set(p, newEntry);
			rebalanceAccess(p);
			return old;
		}
	}
	
	private void set(Position<Entry<K,V>> p, Entry<K,V> entry){
		// This should wire into the re-balancing tree for the action
	}
	
	public V remove(K key) throws IllegalArgumentException{
		checkKey(key);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if(tree.isExternal(p)){		// item to be removed was not found
			rebalanceAccess(p);
			return null;
		}else{
			V old = p.getElement().getValue();
			if(isInternal(left(p)) && isInternal(right(p))){	// if this position has two internal children
				Position<Entry<K,V>> replacement = treeMax(left(p));	// find max closes to this and replace
				set(p, replacement.getElement());
				p = replacement;
			}
			// at this point we guarantee that the node has only at most one internal child
			// we get a reference to the leaf side and its sibling
			Position<Entry<K,V>> leaf = (isExternal(left(p))? tree.left(p) : tree.right(p));
			Position<Entry<K,V>> sib = tree.sibling(leaf);
			remove(leaf);
			remove(p);
			rebalanceDelete(sib);
			return old;
		}
	}
	
	protected Position<Entry<K,V>> treeMax(Position<Entry<K,V>> p){
		Position<Entry<K,V>> walk = p;
		while (tree.isInternal(walk))
			walk = tree.right(walk);	// going right all the way to a sentinel
		return tree.parent(walk);		// the parent of that sentinel will always be greatest in sub-tree
	}
	
	public Entry<K,V> lastEntry(){
		if(isEmpty()) return null;
		return treeMax(tree.root()).getElement();
	}
	
	@Override
	public Entry<K, V> firstEntry() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// floor is the actual value or the one just before it
	public Entry<K,V> floorEntry(K key) throws IllegalArgumentException{
		checkKey(key);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if(isInternal(p)) return p.getElement();	// successful match
		// at this point the position has landed at a sentinel node or its an empty tree
		// 
		while(!isRoot(p)){
			// if p is a right Then on its final check before reaching a sentinel it it found 
			// its parent to be smaller than the key given, so this parent is what we need
			if(p == right(parent(p)))
				return parent(p).getElement();
			
			// if on the other hand p ended on the left side of its parent then the parent was greater
			// than the value of k. We move up and check to see again if we are a right child of something
			else
				p = parent(p);
		}
		
		// if we reach the root then there is no value equal to or less than the key
		return null;
	}

	@Override
	public Entry<K, V> ceilingEntry(K key) {
		checkKey(key);
		Position<Entry<K,V>> p = treeSearch(root(), key);
		if(isInternal(p)) return p.getElement();
		while(!isRoot(p)){
			if(p == left(parent(p)))
				return parent(p).getElement();
			else
				p = parent(p);
		}
		return null;
	}

	@Override
	public Entry<K, V> lowerEntry(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> higherEntry(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
		Entry<K,V> toEntry = new MapEntry<>(toKey, null);
		if(compare(fromKey, toEntry)<0)
			subMapRecurse(fromKey, toKey, tree.root(), buffer);
		return buffer;
	}
	
	private void subMapRecurse(K fromKey, K toKey, Position<Entry<K,V>> p,
			ArrayList<Entry<K,V>> buffer){
		// FIXME
		/*	
		if(tree.isInternal(p))
			if(compare(p.getElement(), toEntry) < 0)
				subMapRecurse(fromKey, toKey, tree.right(p), buffer);
			else{
				subMapRecurse(fromKey, toKey, tree.left(p), buffer);
				if(compare(p.getElement(), toKey) < 0) {
					buffer.add(p.getElement());
					subMapRecurse(fromKey, toKey, tree.right(p), buffer);
				}
			}
			*/
	}

	@Override
	public Iterable<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
		for(Position<Entry<K,V>> p : tree.inorder())
			if(tree.isInternal(p))
				buffer.add(p.getElement());
		return buffer;
	}
	
}
