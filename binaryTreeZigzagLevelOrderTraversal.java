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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList();
        
        if(root == null) return result;
        
        Stack<TreeNode> currLevel = new Stack();
        Stack<TreeNode> nextLevel = new Stack();
        
        currLevel.push(root);
        boolean leftToRight = true;
        
        ArrayList<Integer> thisLevel = new ArrayList();
        while(currLevel.size() > 0) {
            
            TreeNode node = currLevel.pop();
            thisLevel.add(node.val);
            
            if(leftToRight) {
                if(node.left != null) {
                    nextLevel.push(node.left);
                }
                
                if(node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if(node.right != null) {
                    nextLevel.push(node.right);
                }
                
                if(node.left != null) {
                    nextLevel.push(node.left);
                }
                
            }
            
            if(currLevel.size() == 0) {
                leftToRight = !leftToRight;
                result.add(new ArrayList(thisLevel));
                thisLevel.clear();
                
                Stack<TreeNode> tmp = currLevel;
                currLevel = nextLevel;
                nextLevel = tmp;
            }
            
        }
        
        return result;
    }
}