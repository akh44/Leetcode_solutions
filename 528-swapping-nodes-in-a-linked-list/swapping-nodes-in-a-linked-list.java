/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr=head;
        ListNode first=null,second=null;
        int length=0;
        while(curr!=null)
        {
            length++;
            if(length==k)
            {
               first=curr;
            }
            curr=curr.next;
        }

        curr=head;

        for(int i=0;i<length-k;i++)
        {
            curr=curr.next;
        }
        second=curr;

        int tmp=first.val;
        first.val=second.val;
        second.val=tmp;

        return head;
    }
}