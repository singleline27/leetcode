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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length == 0) return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        int rIndex = -1;
        for(int i = 0; i < inorder.length; ++i) {
            if(inorder[i] == postorder[postorder.length-1]) {
                rIndex = i;
                break;
            }
        }
        
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rIndex), Arrays.copyOfRange(postorder, 0, rIndex));
        root.right = buildTree(Arrays.copyOfRange(inorder, rIndex + 1, inorder.length), Arrays.copyOfRange(postorder, rIndex, postorder.length - 1));
        
        return root;
    }
}