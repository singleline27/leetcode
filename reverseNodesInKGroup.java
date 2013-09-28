/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        if(k <= 1) return head;
        
        ListNode p = head;
        ListNode newHead = null;
        ListNode curr = head;
        
        boolean done = false;
        while(!done) {
            int count = 1;
            while(p != null && count < k) {
                p = p.next;
                ++count;
            }
            
            if(p == null) {
                done = true;
            } else {
                if(newHead == null) {
                    reverse(curr, p);
                    newHead = p;
                } else {
                    ListNode next = curr.next;
                    reverse(next, p);
                    curr.next = p;
                    curr = next;
                }
                p = curr.next;
            }
        }
        return newHead == null ? head : newHead;
    }
    
    private void reverse(ListNode head, ListNode tail) {
        if(head == tail) return;
        ListNode next = tail.next;
        
        reverse(head.next, tail);
        head.next.next = head;
        head.next = next;
    }
}