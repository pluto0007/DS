package org.com.exam.module1;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
public class BinarySearchTree {

	static Node root;

	class Node {
		int key;
		// parent is used to find the depth of the node
		Node left, right, parent, next;

		public Node(int item) {
			this.key = item;
			this.left = this.right = this.parent = null;
		}
	}

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int key) {
		root = insertItem(root, key);
	}

	// first insert it as root, then insert to the left of the parent(root.left) if
	// the element is smaller then the root, if not then insert it in the
	// right(root.right)
	public Node insertItem(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		} else {
			if (key < root.key) {
				root.left = insertItem(root.left, key);
				root.left.parent = root;
			} else if (key > root.key) {
				root.right = insertItem(root.right, key);
				root.right.parent = root;
			}
		}
		return root;
	}

	/*
	 * The height of a binary tree is the number of edges between the tree's root
	 * and its farthest leaf.
	 */ public void height(Node root) {
		System.out.println("height of the tree: " + heightOfNode(root));
	}

	public int heightOfNode(Node root) {

		if (root == null)
			return -1;
		else {
			int leftHeight = heightOfNode(root.left);
			int rightHeight = heightOfNode(root.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}

	}

	// It is defined as the number of the edges between the root node to the entered
	// node.
	public int depthOfNode(Node node) {
		int counter = 0;
		if (node.parent == null) {
			return 0;
		} else {
			while (node != root) {
				counter++;
				node = node.parent;
			}
			return counter;
		}
	}

	public void inOrder() {
		printInOrder(root);
	}

	// first print left, then parent, then right, we make use of recursive call, so
	// that element will be put under JVM stack and picked from it
	public void printInOrder(Node root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.println(root.key + "-->");
			printInOrder(root.right);
		}
	}

	public void preOrder() {
		printPreOrder(root);
	}

	// first print parent, then left, then right, we make use of recursive call, so
	// that element will be put under JVM stack and picked from it
	public void printPreOrder(Node root) {
		if (root != null) {
			System.out.println(root.key + "-->");
			printPreOrder(root.left);
			printPreOrder(root.right);
		}
	}

	public int findMinimum() {
		return findMin(root).key;
	}

	// Minimum element would be the left most element in the tree
	public Node findMin(Node root) {
		while (root.left != null) {
			root = root.left;
			findMin(root);

		}
		return root;
	}

	public int findMaximum() {
		return findMax(root);
	}

	// Maximum element would be the right most element in the tree
	public int findMax(Node root) {
		while (root.right != null) {
			root = root.right;
			findMax(root);

		}
		return root.key;
	}

	/*
	 * (Idea here, enQueue the children in Queue before dequeue the currentNode
	 * which is the peeked Node )
	 * 1. Start from the node which is root and enqueue it in queue. 
	 * 2. Perform peek-call it as currentNode, and print it. 
	 * 3. check if left child of currentNode is there, enqueue it, check if right child of
	 * currentNode is there, enqueue it.
	 * 4. Dequeue the currentNode.
	 * 
	 * Level order traversal
	 */
	public void breadthFirstSearchTraversal() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(queue!=null) {
			Node currentNode = queue.peek();
			System.out.println(currentNode);
			if(currentNode.left!=null) {
				queue.add(currentNode.left);
			}
			if(currentNode.right!=null) {
				queue.add(currentNode.right);
			}
			queue.remove(currentNode);
		}
	}

	// Have to correct it,its wrong
	public void topView(Node root) {
		while (root != null) {
			System.out.println(root.key);
			root = root.right;
		}
	}

	boolean isBST() {
		return isBSTExist(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isBSTExist(Node node, int minValue, int maxValue) {
		if (null == node) {
			return true;
		}
		
		if(node.key<minValue || node.key>maxValue) {
			return false;
		}
		return (isBSTExist(node.left, minValue, node.key-1) && isBSTExist(node.right, node.key+1, maxValue));
	}

	// This method mainly calls deleteRec()
	void deleteKey(int key) {
		root = deleteNode(root, key);
	}

	/* A recursive function to delete a key in BST */
	Node deleteNode(Node root, int key) {
		/* Base Case: If the tree is empty */
		if (root == null) {
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key) {
			root.left = deleteNode(root.left, key);
		}

		else if (key > root.key) {
			root.right = deleteNode(root.right, key);
		}

		// if key is same as root's key, then This is the node
		// to be deleted
		else {
			// node with only one child or no child, we have to update the parent node as
			// well as while deleting any node
			// start pointing it current node's parent
			if (root.left == null) {
				if (root.right != null) {
					root.right.parent = root.parent;
				}

				return root.right;
			} else if (root.right == null) {
				if (root.left != null) {
					root.left.parent = root.parent;
				}
				return root.left;
			}

			// node with two children: Get the in-order successor (smallest in the right subtree)
			root.key = findMin(root.right).key;

			// Delete the in-order successor
			root.right = deleteNode(root.right, root.key);
		}

		return root;
	}

	public int next_Larger(int key) {
		return find_Next_larger(root, key).key;
	}

	public Node find_Next_larger(Node root, int key) {

		/* Reaching to the desired Node through recursion */

		Node node = root;
		if (key < node.key) {
			node.left = find_Next_larger(node.left, key);
			node = node.left; // we are assigning it here so that value get reflected in the node variable otherwise it won't be reflected
		} else if (key > node.key) {
			node.right = find_Next_larger(node.right, key);
			node = node.right;
		}

		else {
			/*
			 * Case 1: x has a right sub-tree where all keys are larger than x.key. The next
			 * larger key will be the minimum key of x’s right sub-tree
			 */

			if (node.right != null) {
				return findMin(node.right);
			}

			/*
			 * Case 2: x has no right sub-tree. We can find the next larger key by
			 * traversing up x’s ancestry until we reach a node that x is left child of.
			 * That node’s parent will contain the next larger key. think about element 40
			 * whose next largest element would be 50 as it move up it will find 30 which is the left child of its parent
			 */

			else {
				while (node.parent != null && node == node.parent.right) {
					node = node.parent;
				}
				node = node.parent;
				return node;
			}
		}
		return node;
	}

	public Node find_LCA(int n1, int n2) {
		return LCA(root, n1, n2);
	}

	// To find LCA(lowest common ancestor) of nodes n1 and n2 in Binary Tree
	// https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	Node LCA(Node node, int n1, int n2) {
		if (node == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (node.key > n1 && node.key > n2)
			return LCA(node.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (node.key < n1 && node.key < n2)
			return LCA(node.right, n1, n2);

		return node;
	}

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(50);
		binarySearchTree.insert(30);
		binarySearchTree.insert(20);
		binarySearchTree.insert(40);
		binarySearchTree.insert(31);
		binarySearchTree.insert(70);
		binarySearchTree.insert(60);
		binarySearchTree.insert(80);
		binarySearchTree.insert(10);
		binarySearchTree.breadthFirstSearchTraversal();
		/*
		 * binarySearchTree.topView(root); binarySearchTree.height(root);
		 * System.out.println("depth of node : "+binarySearchTree.depthOfNode(root.left.
		 * left));
		 * 
		 * System.out.println("inorder :"); binarySearchTree.inOrder();
		 * System.out.println("pre order :"); binarySearchTree.preOrder();
		 * 
		 * System.out.println("minimum item : " + binarySearchTree.findMinimum());
		 * System.out.println("maximum item : " + binarySearchTree.findMaximum());
		 * 
		 * System.out.println(binarySearchTree.isBSTExist());
		 */
		binarySearchTree.deleteKey(30);
		// binarySearchTree.inOrder();
		// binarySearchTree.deleteKey(30);

		// System.out.println(binarySearchTree.next_Larger(30));
		// System.out.println(binarySearchTree.next_Larger(40));
		// System.out.println(binarySearchTree.next_Larger(31));

		// System.out.println(binarySearchTree.find_LCA(10, 31).key);

	}

}
