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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        
        p1.val += p2.val;
        if(p1.val >= 10) {
            p1.val -= 10;
            carry = 1;
        }
        while(p1.next != null && p2.next != null) {
            p1.next.val += p2.next.val + carry;
            if(p1.next.val >= 10) {
                p1.next.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        
        if(p2.next != null) {
            p1.next = p2.next;
        }

        while(p1.next != null) {
            p1.next.val += carry;
            if(p1.next.val >= 10) {
                p1.next.val -= 10;
                carry = 1;
                p1 = p1.next;
            } else {
                carry = 0;
                break;
            }
        }
            
        if(carry == 1) {
            p1.next = new ListNode(1);
        }
            
        return l1;
    }
}