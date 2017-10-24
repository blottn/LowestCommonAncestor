package org.blottn.lca;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.ArrayList;
/*
 *  Created by Nicholas Blott
 *
 *  Class used to find the lowest common ancestor between two nodes in a binary tree (unsorted)
 *
 */

public class LCAFinder {

    public static final int NONE = -1;

    private int root;

	private Node[] dag;

	class Node {
		int parent;
		int left;
		int right;
		public Node(int left, int right, int parent) {
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}

    public LCAFinder(int size, int root) {
		dag = new Node[size];
		for (int i = 0; i < dag.length ; i++) {
			dag[i] = new Node(NONE, NONE, NONE);
		}
		this.root = root;
    }

    public int lca(int keyA, int keyB) {
        return root;	//TODO implement this
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
		if (dag[key].left != NONE) {
			dag[dag[key].left].parent = NONE;
		}
		dag[key].left = left;
		if (dag[left].parent != NONE) {
			if (dag[dag[left].parent].left == left) {
				dag[dag[left].parent].left = NONE;
			}
			if (dag[dag[left].parent].right == left) {
				dag[dag[left].parent].right = NONE;
			}
		}

		dag[dag[key].left].parent = key;
    }

    public void setRight(int key, int right) {
		if (dag[key].right != NONE) {	//if it has a right node, set that ones parent to NONE
			dag[dag[key].right].parent = NONE;
		}
		dag[key].right = right;
		if (dag[right].parent != NONE) {
			if (dag[dag[right].parent].right == right) {
				dag[dag[right].parent].right = NONE;
			}
			if (dag[dag[right].parent].left == right) {
				dag[dag[right].parent].left = NONE;
			}
		}

		dag[dag[key].right].parent = key;
    }
}
