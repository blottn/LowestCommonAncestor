package org.blottn.lca;

import java.util.concurrent.ConcurrentLinkedQueue;
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

	private Node[] dag;

	class Node {
		int left;
		int right;
		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "[" + "left: " + left + ", right: " + right + "]";
		}
	}

    public LCAFinder(int size, int root) {
		dag = new Node[size];
		for (int i = 0; i < dag.length ; i++) {
			dag[i] = new Node(NONE, NONE);
		}
		this.root = root;
    }

    public int lca(int keyA, int keyB) {
        return lcaHelper(root, keyA, keyB);
	}

	// Invariants:
	/*
		keyA and keyB are children of start.
	*/
	private int lcaHelper(int start, int keyA, int keyB) {
		if (start == keyA || start == keyB) {
			return start;
		}
		else {
			if (contains(dag[start].left, keyA) && contains(dag[start].left, keyB)) {
				return lcaHelper(dag[start].left, keyA, keyB);
			}
			else if (contains(dag[start].right, keyA) && contains(dag[start].right, keyB)) {
				return lcaHelper(dag[start].left, keyA, keyB);
			}
		   	else {
				return start;
			}
		}
	}

	private boolean contains(int start, int key) {
		if (start == NONE)
			return false;

		if (start == key) {
			return true;
		}
		else {
			return contains(dag[start].left,key) || contains(dag[start].right,key);
		}
	}

    public int getRoot() {
        return root;
    }

    public int getRight(int key) {
		return dag[key].right;
    }

    public int getLeft(int key) {
        return dag[key].left;
    }

    public void setLeft(int key, int left) {
		dag[key].left = left;
    }

    public void setRight(int key, int right) {
		dag[key].right = right;
    }

	@Override
	public String toString() {
		String out = "";
		for (int i = 0 ; i < dag.length ; i++) {
			String tuple = dag[i].toString();
			out += tuple;
			out += " ";
		}
		return out;
	}

}
