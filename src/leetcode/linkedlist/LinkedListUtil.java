package leetcode.linkedlist;

import java.util.HashSet;

public class LinkedListUtil {
    public static void printLL(ListNode node) {
        HashSet<ListNode> visited = new HashSet<>();
        while (node!=null) {
            System.out.print(node.val);
            if(visited.contains(node)) { // for linkedlist cycle
                break;
            }
            visited.add(node);
            if(node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
    }
}
