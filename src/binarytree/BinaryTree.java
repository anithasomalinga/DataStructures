package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    // Level by level traversal
    public void levelOrderTraversalBFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    // DFS - uses recursion and backtracking
    // process current, left, right
    public void preOrderTraversalDFS(Node currentNode) {
        if(currentNode == null) return;
        System.out.print(currentNode.value + " ");
        preOrderTraversalDFS(currentNode.left);
        preOrderTraversalDFS(currentNode.right);
    }

    // process left, current, right
    public void inOrderTraversalDFS(Node currentNode) {
        if(currentNode == null) return;
        inOrderTraversalDFS(currentNode.left);
        System.out.print(currentNode.value + " ");
        inOrderTraversalDFS(currentNode.right);
    }

    // process left, right, current
    public void postOrderTraversalDFS(Node currentNode) {
        if(currentNode == null) return;
        postOrderTraversalDFS(currentNode.left);
        postOrderTraversalDFS(currentNode.right);
        System.out.print(currentNode.value + " ");
    }
}
