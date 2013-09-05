/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        
        Queue<TreeLinkNode> q = new LinkedList();
        q.add(root);
        
        
        while(q.size() > 0) {
            TreeLinkNode node = q.poll();
            
            TreeLinkNode last = null;
            if(node.left != null) {
                q.add(node.left);
                last = node.left;
            }
            
            if(node.right != null) {
                q.add(node.right);
                if(node.left != null) {
                    node.left.next = node.right;
                }
                last = node.right;
            }
            
            if(last != null) {
                TreeLinkNode next = node.next;
                while(next != null && next.left == null && next.right == null) next = next.next;
            
                if(next != null) {
                    if(next.left != null) {
                        last.next = next.left;
                    } else {
                        last.next = next.right;
                    }
                }
            }
        }
        
    }
}