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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        
        ListNode p = head;
        ListNode newHead = head;
        while(p != null && p.next != null && p.next.val == p.val) {

            while(p.next != null && p.next.val == p.val) {
                p = p.next;
            }
            
            if(p.next == null) return null;
            
            newHead = p.next;
            p = p.next;
        }
        
        p = newHead;
        while(p.next != null) {
            if(p.next.next != null && p.next.next.val == p.next.val) {
                ListNode q = p.next.next;
                while(q.next != null && q.next.val == p.next.val) {
                    q = q.next;
                }
                
                p.next = q.next;
                
            } else {
                p = p.next;
            }
        }
        
        return newHead;
    }
}