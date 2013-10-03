/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        map = new HashMap<Integer, UndirectedGraphNode>();
        return doClone(node);
    }
    
    private UndirectedGraphNode doClone(UndirectedGraphNode node) {
        if(node == null) return null;
        if(map.containsKey(node.label)) {
            return map.get(node.label);
        }
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);
        for(UndirectedGraphNode n: node.neighbors) {
            newNode.neighbors.add(doClone(n));
        }
        return newNode;
    }
}