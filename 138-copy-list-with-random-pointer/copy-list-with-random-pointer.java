/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         if (head == null) {
            return null;
        }

        // Step 1: Clone nodes and interleave them with original nodes
        Node current = head;
        while (current != null) {
            Node clonedNode = new Node(current.val);
            clonedNode.next = current.next;
            current.next = clonedNode;
            current = clonedNode.next;
        }

        // Step 2: Assign random pointers for cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the cloned list from the original list
        current = head;
        Node clonedHead = head.next;
        Node clonedCurrent = clonedHead;

        while (current != null) {
            current.next = current.next.next;
            if (clonedCurrent.next != null) {
                clonedCurrent.next = clonedCurrent.next.next;
            }
            current = current.next;
            clonedCurrent = clonedCurrent.next;
        }

        return clonedHead;
    }
}