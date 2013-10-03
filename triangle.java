public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = triangle.size();
        if(len == 0) return 0;
        
        int[] curr = new int[len];
        int[] last = new int[len];
        
        last[0] = triangle.get(0).get(0);
        for(int i = 1; i < len; ++i) {
            ArrayList<Integer> level = triangle.get(i);
            
            curr[0] = last[0] + level.get(0);
            for(int j = 1; j < i; ++j) {
                curr[j] = Math.min(last[j - 1], last[j]) + level.get(j);
            }
            curr[i] = last[i - 1] + level.get(i);
            
            last = curr;
            curr = new int[len];
        }
        
        int value = last[0];
        for(int i = 1; i < len; ++i) {
            value = Math.min(value, last[i]);
        }
        return value;
    }
}