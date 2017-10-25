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
		dag[key].left = left;
    }

    public void setRight(int key, int right) {
		dag[key].right = right;
    }
}
