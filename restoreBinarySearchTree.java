/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        
        TreeNode first = null;
        TreeNode second = null;
        
        boolean done = false;
        
        Stack<TreeNode> s = new Stack();
        TreeNode curr = root;
        TreeNode last = null;
        TreeNode firstSwitch = null;
        while(!done) {
            
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            
            if(s.size() == 0) {
                done = true;
            } else {
                curr = s.pop();
                
                if(first == null) {
                    if(last != null && last.val > curr.val) {
                        first = last;
                        firstSwitch = curr;
                    }
                } else {
                    
                    if(second == null) {
                        if(last != null && last.val > curr.val) {
                            second = curr;
                            break;
                        }
                    }
                
                    
                }
                last = curr;
                curr = curr.right;
            }
            
        }
        
        if(first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
            return;
        }
        
        if(first != null) {
            int tmp = first.val;
            first.val = firstSwitch.val;
            firstSwitch.val = tmp;
        }
    }
}