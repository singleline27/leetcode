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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> currLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        
        currLevel.add(root);
        
        while(currLevel.size() > 0) {
            ArrayList<Integer> thisLevel = new ArrayList<Integer>();
            while(currLevel.size() > 0) {
                TreeNode curr = currLevel.poll();
                thisLevel.add(curr.val);
                
                if(curr.left != null) nextLevel.add(curr.left);
                if(curr.right != null) nextLevel.add(curr.right);
            }
            res.add(thisLevel);
            currLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
            
        }
        return res;
    }
}