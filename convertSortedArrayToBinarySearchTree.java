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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(num[start]);
        
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        
        return root;
    }
}