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

	private int lcaHelper(int start, int keyA, int keyB) {
		return start;
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

    public void setLeft(int key, int left) {	//TODO Assert doesn't form cycle
		dag[key].left = left;
    }

    public void setRight(int key, int right) {	//TODO Assert doesn't form cycle
		dag[key].right = right;
    }
}
