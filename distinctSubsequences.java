public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
            
        if(T == null || S == null) return 0;
        if(T.equals("")) return 1;

        int m = S.length();
        int n = T.length();
        int[] dp = new int[n+1];

        dp[0] = 1;
        
        for(int i = 1; i <= m; ++i) {
            for(int j = n; j > 0; --j) {
                if(S.charAt(i-1) == T.charAt(j-1) && dp[j - 1] > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[n];
            
    }
    
}