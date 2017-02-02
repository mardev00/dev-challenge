package com.dev.algorithms;

import java.util.Random;

/**
 * Class NodeTree represents a Binary Tree
 * 
 * @author martinarmenta
 *
 */
public class NodeTree {

	NodeTree left;
	NodeTree right;
	String value;
	int data;

	NodeTree(int data) {
		this.data = data;
	}

	public static void main(String args[]) {
		Random rand = new Random();

		int[] randomNums = new int[100];
		NodeTree root = new NodeTree(rand.nextInt(100));
		root.data = rand.nextInt(100);

		for (int i = 1; i < randomNums.length; i++) {
			randomNums[i] = rand.nextInt(100);
		}
		populateTree(root, randomNums);
		System.out.println("");

		System.out.println("");
		System.out.println("POST ORDER:");
		postOrder(root);

	}

	/*
	 * private auxiliary method to populate the tree using an array
	 */

	private static NodeTree populateTree(NodeTree current, int[] array) {
		for (int val : array) {
			insert(current, new NodeTree(val));

		}
		return current;
	}

	/*
	 * insert method does the actual work of populating all the nodes in the
	 * Binary tree
	 */
	public static NodeTree insert(NodeTree current, NodeTree node) {
		if (node.data < current.data) {
			if (current.left == null)
				current.left = node;
			else
				insert(current.left, node);
		}
		if (node.data > current.data) {
			if (current.right == null)
				current.right = node;
			else
				insert(current.right, node);
		}
		return node;
	}

	/**
	 * method postOrder flattens tree while visiting the tree in postOrder
	 * 
	 * @param current
	 */
	public static void postOrder(NodeTree current) {
		if (current == null)
			return;
		postOrder(current.left);
		postOrder(current.right);
		System.out.print(" " + current.data);
	}

}
