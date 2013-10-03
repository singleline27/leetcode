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
    private ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        result = new ArrayList<ArrayList<Integer>>();
        
        generate(root, sum, new ArrayList<Integer>());
        return result;
    }
    
    private void generate(TreeNode root, int sum, ArrayList<Integer> curr) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                curr.add(root.val);
                result.add(curr);
            }
            return;
        }
        
        if(root.left != null) {
            ArrayList<Integer> left = new ArrayList<Integer>(curr);
            left.add(root.val);
            generate(root.left, sum - root.val, left);
        }
        
        if(root.right != null) {
            ArrayList<Integer> right = new ArrayList<Integer>(curr);
            right.add(root.val);
            generate(root.right, sum - root.val, right);
        }
    }
}