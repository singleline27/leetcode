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

            if(node.left != null) {
                q.add(node.left);
                q.add(node.right);
                
                node.left.next = node.right;
                
                if(node.next != null) {
                    node.right.next = node.next.left;
                }
            }
        }
        
    }
}