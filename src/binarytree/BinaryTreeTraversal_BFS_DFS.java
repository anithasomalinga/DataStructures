package binarytree;

/*
     1
   /   \
  2     3
 /     / \
4      5  6
        \
         7
*/
public class BinaryTreeTraversal_BFS_DFS {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        one.left = two;
        one.right = three;

        two.left = four;

        three.left = five;
        three.right = six;

        five.right = seven;

        BinaryTree tree = new BinaryTree(one);
        // print tree
        new BinaryTreeViewPrinter().printNode(tree.root);

        // BFS - Queues - Level order traversal
        System.out.println("BFS - Queues - Level order traversal");
        tree.levelOrderTraversalBFS();

        // DFS - PreOrder Traversal
        System.out.println("\nDFS - PreOrder Traversal");
        tree.preOrderTraversalDFS(tree.root);

        // DFS - InOrder Traversal
        System.out.println("\nDFS - InOrder Traversal");
        tree.inOrderTraversalDFS(tree.root);

        // DFS - PostOrder Traversal
        System.out.println("\nDFS - PostOrder Traversal");
        tree.postOrderTraversalDFS(tree.root);
    }

}
