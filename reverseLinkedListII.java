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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p1 = head;
        ListNode p2;
        int i = 1;
        while(i < m - 1) {
            p1 = p1.next;
            ++i;
        }
        
        p2 = p1;
        while(i < n) {
            p2 = p2.next;
            ++i;
        }
        
        ListNode tail = p2.next;
        if(m == 1) {
            reverse(p1, p2);
            p1.next = tail;
            return p2;
        } else {
            reverse(p1.next, p2);
            p1.next.next = tail;
            p1.next = p2;
            return head;
        }        
    }
    
    private void reverse(ListNode p1, ListNode p2) {
        if(p1 == p2) return;
        ListNode next = p1.next;
        reverse(next, p2);
        
        next.next = p1;
        p1.next = null;
    }
}