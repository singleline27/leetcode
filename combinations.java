public class Solution {
    private ArrayList<ArrayList<Integer>> result;
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList();
        
        if(k == 0 || k > n) return result;
        
        ArrayList<Integer> curr = new ArrayList();
        find(1, n, k, curr);
        
        return result;
    }
    
    private void find(int start, int end, int k, ArrayList<Integer> curr) {
        
        if(k == 0) {
            result.add(new ArrayList(curr));
            return;
        }
        
        for(int i = start; i <= end - k + 1; ++i) {
            ArrayList<Integer> tmp = new ArrayList(curr);
            tmp.add(i);
            find(i + 1, end, k - 1, tmp);
        }
        
    }
}