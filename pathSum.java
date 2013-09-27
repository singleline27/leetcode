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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return false;
        
        int val = root.val;
        if(root.left == null && root.right == null) return val == sum;
    
        if(root.left != null) {
            if(hasPathSum(root.left, sum - val)) {
                return true;
            }
        }
        if(root.right != null) {
            if(hasPathSum(root.right, sum - val)) {
                return true;
            }
        }
        return false;
    }
}