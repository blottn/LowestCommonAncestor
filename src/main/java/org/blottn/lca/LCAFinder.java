package org.blottn.lca;

import java.util.concurrent.ConcurrentLinkedQueue;

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
        Node left, right, parent;

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
        Node node = find(key);
        if (node == null || node.right == null) {
            return NONE;
        }
        return find(key).right.key;
    }

    public int getLeft(int key) {
        Node node = find(key);
        if (node == null || node.left == null) {
            return NONE;
        }
        return find(key).left.key;
    }

    public void setLeft(int original, int key) {
        Node node = find(original);
        if (node != null) {
            node.left = new Node(key);
        }
    }

    public void setRight(int original, int key) {
        Node node = find(original);
        if (node != null) {
            node.right = new Node(key);
        }
    }

    private Node find(int key) {
        ConcurrentLinkedQueue<Node> queue = new ConcurrentLinkedQueue<Node>();
        queue.add(this.root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.key == key) {
                return current;
            }
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return null;
    }

}
