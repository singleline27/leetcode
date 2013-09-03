public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
            
        if(T == null || S == null) return 0;
        if(T.equals("")) return 1;
        
        return findSub(S, T, 0, 0);
    }
    
    private int findSub(String S, String T, int i, int j) {
    
        if(j == T.length()) return 1;
        
        if(i >= S.length() || j > T.length()) return 0;
        
        char c = T.charAt(j);
        int curr = S.indexOf(c, i);
        int sum = 0;
        
        while(curr >= 0) {
            
            sum += findSub(S, T, curr + 1, j + 1);
            
            curr = S.indexOf(c, curr + 1);
        }
        
        return sum;
    }
}