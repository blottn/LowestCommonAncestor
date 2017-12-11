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
	}

    public LCAFinder(int size, int root) {
		dag = new HashMap<Integer,Tuple>();
		this.root = root;
    }
	
	//Returns the leftmost lca of keyA and keyB
    public int lca(int keyA, int keyB) {
		if (!contains(root,keyA) || !contains(root,keyB)) {
			return NONE;
		}
        return lcaHelper(root, keyA, keyB);
	}

	// Invariant:
	/*
		keyA and keyB are children of start.
	*/
	private int lcaHelper(int start, int keyA, int keyB) {
		return NONE;
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
		return NONE;
    }

    public int getLeft(int key) {
        return NONE;
    }

    public void setLeft(int key, int left) {
    }

    public void setRight(int key, int right) {
    }
}
