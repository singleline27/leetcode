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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        
        if(!isValidBST(root.left) || !isValidBST(root.right)) return false;
        
        return minValue(root.right) > root.val && maxValue(root.left) < root.val;
        
    }
    
    private int minValue(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
            
        return Math.min(Math.min(root.val, minValue(root.left)), minValue(root.right));
    }
    
    private int maxValue(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
            
        return Math.max(Math.max(root.val, maxValue(root.left)), maxValue(root.right));
    }
}

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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        
        Stack<TreeNode> stack = new Stack();
        boolean done = false;
        TreeNode curr = root;
        
        int last = Integer.MIN_VALUE;
        while(!done) {
            
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            if(stack.empty()) {
                done = true;
            } else {
                TreeNode node = stack.pop();
                if(node.val <= last) {
                    return false;
                }
                
                last = node.val;
                curr = node.right;
            }
        }
        
        return true;
    }
    
}