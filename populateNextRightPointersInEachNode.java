/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    final static private class Pair {
        final public TreeLinkNode node;
        final public int level;
        
        Pair(TreeLinkNode node, int level) {
            this.node = node;
            this.level = level;
        }
    };
    
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return;
        
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(root, 0));
        
        Pair last = null;
        while(q.size() > 0) {
            Pair pair = q.poll();
            TreeLinkNode node = pair.node;
            int level = pair.level;
            
            if(last != null && last.level == level) {
                last.node.next = node;
            }
            
            if(node.left != null) {
                q.add(new Pair(node.left, level + 1));
            }
            
            if(node.right != null) {
                q.add(new Pair(node.right, level + 1));
            }
            
            last = pair;
        }
        
    }
}