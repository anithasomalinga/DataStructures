package leetcode.linkedlist;

/*
*** Delete Node in a Linked List ***

There is a singly-linked list head and we want to delete a node in it.

You are given the node to be deleted node. You will not be given access to the first node of head.

All the values of the linked list are unique, and it is guaranteed that the given node is not the last node in the linked list.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before node should be in the same order.
All the values after node should be in the same order.

 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        LinkedListUtil.printLL(head);
        deleteNode(n2);
        System.out.println();
        LinkedListUtil.printLL(head);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
