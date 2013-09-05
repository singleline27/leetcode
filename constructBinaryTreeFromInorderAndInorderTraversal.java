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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend ) {
        
        if(preend < prestart) return null;
        
        TreeNode root = new TreeNode(preorder[prestart]);
        
        int rIndex = -1;
        for(int i = instart; i <= inend; ++i) {
            if(inorder[i] == preorder[prestart]) {
                rIndex = i;
                break;
            }
        }
        int leftNode = rIndex - instart;
        
        root.left = buildTree(preorder, prestart + 1, prestart + leftNode, inorder, instart, instart + leftNode - 1);
        root.right = buildTree(preorder, prestart + leftNode + 1, preend, inorder, rIndex + 1, inend);
        
        return root;
        
    }
}