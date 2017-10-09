package org.blottn.lca;

/*
 *  Created by Nicholas Blott
 *
 *  Class used to find the lowest common ancestor between two nodes in a binary tree (unsorted)
 *
 */

public class LCAFinder {

    public static final int NONE = -1;

    private Node root;

    class Node {
        
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    public LCAFinder(int root) {
        this.root = new Node(root);
    }

    public int lca(int keyA, int keyB) {
        return 0;
    }

    public int getRoot() {
        return root.key;
    }

    public int getRight(int key) {
        return 0;
    }
    
    public int getLeft(int key) {
        return 0;
    }

    public void setLeft(int original, int key) {
        
    }

    public void setRight(int original, int key) {

    }
}
