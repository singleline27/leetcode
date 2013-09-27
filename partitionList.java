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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p = head;
        
        while(p != null) {
            if(p.val < x) {
                if(l1 == null) {
                    l1 = p;
                    p1 = p;
                } else {
                    p1.next = p;
                    p1 = p;
                }
            } else {
                if(l2 == null) {
                    l2 = p;
                    p2 = p;
                } else {
                    p2.next = p;
                    p2 = p;
                }
            }
            p = p.next;
        }
        
        if(p1 != null) {
            p1.next = l2;
        } else {
            return l2;
        }
        
        if(p2 != null) {
            p2.next = null;
        }
        
        return l1;
    }
}