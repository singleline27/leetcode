public class Solution {
    private ArrayList<String> result;
    public ArrayList<String> generateParenthesis(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        result = new ArrayList<String>();
        if(n == 0) return result;
        generate(n, 0, 0, "");
        return result;
    }
    
    private void generate(int n, int leftCount, int level, String curr) {
        if(curr.length() == n *2) {
            result.add(curr);
            return;
        }
        
        if(leftCount < n) {
            generate(n, leftCount + 1, level + 1, curr+"(");
        }
        
        if(level >= 1) {
            generate(n, leftCount, level - 1, curr+")");
        }
    }
}