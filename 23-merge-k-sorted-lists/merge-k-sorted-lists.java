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
    public ListNode mergeKLists(ListNode[] lists) {
        int amount=lists.length;
        int interval=1;
        while(interval<amount)
        {
            for(int i=0;i<amount-interval;i+=interval*2)
            {
                lists[i]=mergetwoLists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }

        return amount>0?lists[0]:null;
    }
        public ListNode mergetwoLists(ListNode l1, ListNode l2)
        {
            ListNode head=new ListNode(0);
            ListNode point =head;
            while(l1!=null&&l2!=null)
            {
                if(l1.val<=l2.val)
                {
                    point.next=l1;
                    l1=l1.next;
                }
                else
                {
                    point.next=l2;
                    l2=l2.next;
                }
                point=point.next;
            }

            if(l1==null)
            {
                point.next=l2;
            }
            else
            {
                point.next=l1;
            }
            return head.next;
        }
        
    }
