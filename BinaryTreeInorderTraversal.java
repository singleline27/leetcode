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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        boolean done = false;
        
        while(!done) {
            if(curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                if(s.size() == 0) {
                    done = true;
                } else {
                    curr = s.pop();
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
        
    }
}