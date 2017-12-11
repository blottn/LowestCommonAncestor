package org.blottn.lca;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*
 *  Created by Nicholas Blott
 *
 *  Class used to find the lowest common ancestor between two nodes in a binary tree (unsorted)
 *	The lca() method works on the assumption there are no singleton nodes that don't have a reference to them
 *
 */

public class LCAFinder {

	public static final int NONE = -1;

    private int root;

	private Map<Integer,Tuple> dag;

	private static class Tuple {
		
		int left;
		int right;

		public Tuple(int l, int r) {
			this.left = l;
			this.right = r;
		}

		@Override
		public String toString() {
			return "(" + left + " , " + right + ")";
		}
	}

    public LCAFinder(int size, int root) {
		dag = new HashMap<Integer,Tuple>();
		this.root = root;
		dag.put(root,null);
    }
	
	//Returns the leftmost lca of keyA and keyB
    public int lca(int keyA, int keyB) {
		System.out.println(root);
		System.out.println(keyA + " " + keyB);
		System.out.println(this.toString());
		if (!contains(root,keyA) || !contains(root,keyB)) {
			return NONE;
		}
		int current = root;
		while (!split(current,keyA,keyB)){
			if (contains(getRight(current),keyA) ) {
				current = getRight(current);
			}
			else {
				current = getLeft(current);
			}
		}
		return current;
	}

	private boolean split(int root, int l, int r) {
		if (l == root || r == root) {
			return true;
		}
		boolean both_left = (contains(getLeft(root),l) && contains(getLeft(root),r));
		boolean both_right = (contains(getRight(root),l) && contains(getRight(root),r));
		return !(both_left || both_right);
	}

	private boolean contains(int start, int key) {
		if (start == NONE)
			return false;

		if (start == key) {
			return true;
		}
		else {
			return contains(getLeft(start),key) || contains(getRight(start),key);
		}
	}

    public int getRoot() {
        return root;
    }

    public int getRight(int key) {
		if (dag.keySet().contains(key) && dag.get(key) != null) {
			return dag.get(key).right;
		}
		else {
			return NONE;
		}
    }

    public int getLeft(int key) {
		if (dag.keySet().contains(key) && dag.get(key) != null) {
			return dag.get(key).left;
		}
		else {
			return NONE;
		}
    }

    public void setLeft(int key, int left) {
		if (dag.get(key) == null) {
			dag.put(key, new Tuple(NONE, NONE));
		}
		dag.get(key).left = left;
		dag.put(left,new Tuple(NONE,NONE));
    }

    public void setRight(int key, int right) {
		if (dag.get(key) == null) {
			dag.put(key, new Tuple(NONE, NONE));
		}
		dag.get(key).right = right;
		dag.put(right,new Tuple(NONE,NONE));
    }

	@Override
	public String toString() {
		return dag.toString();
	}

}
