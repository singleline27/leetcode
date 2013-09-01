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

    final private class Pair {
        public TreeNode node;
        public int level;
        
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    };
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(root == null) {
            return result; 
        }    
        
        Queue<Pair> q = new LinkedList<Pair>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        q.add(new Pair(root, 0));
        
        while(q.size() > 0) {
            Pair p = q.poll();
            TreeNode curr = p.node;
            int level = p.level;
            
            ArrayList<Integer> list;
            if(map.containsKey(level)) {
                list = map.get(level);
            } else {
                list = new ArrayList<Integer>();    
                map.put(level, list);
            }
            list.add(curr.val);
            
            if(curr.left != null) {
                q.add(new Pair(curr.left, level + 1));
            }
            
            if(curr.right != null) {
                q.add(new Pair(curr.right, level + 1));
            }
            
        }
        
        //for(ArrayList<Integer> list : map.values()) {
        //    result.add(list);
        //}
        
        for(int i = 0; ; ++i) {
            if(map.containsKey(i)) {
                result.add(map.get(i));
            } else {
                break;
            }
        }
        
        return result;
    }
}