class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: If the list is empty or has only one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode middle = getMiddle(head);   // Find the middle node
        ListNode rightHalf = middle.next;    // Right half starts after the middle node
        middle.next = null;                  // Split the list into two halves

        // Step 2: Recursively sort the left and right halves
        ListNode left = sortList(head);      // Sort the left half
        ListNode right = sortList(rightHalf); // Sort the right half

        // Step 3: Merge the sorted halves
        return mergeTwoLists(left, right);
    }

    // Function to find the middle of the linked list using slow and fast pointer approach
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head.next; // Start 'fast' one step ahead to find mid-left
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps
        }
        return slow;  // 'slow' will point to the middle node
    }

    // Function to merge two sorted linked lists
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to build the merged list
        ListNode current = dummy;

        // Compare nodes and append the smaller one to the result list
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append any remaining nodes from either list
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next; // Return the sorted merged list
    }
}
