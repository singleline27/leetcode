public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function   
        if(s.length() == 0) return 0;
        
        char c = s.charAt(0);
        if(c < '1' || c > '9') return 0;
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= s.length(); ++i) {
            char last = s.charAt(i - 2);
            char curr = s.charAt(i - 1);
            if(last < '1' || last > '2' || last == '2' && curr > '6') {
                if(curr != '0')
                    dp[i] = dp[i - 1];
                else 
                    return 0;
            } else if(curr != '0'){
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 2];
            }
        }
        
        
        return dp[s.length()];
    }
    
    private int numDecodings(String s, int i) {
        
        if(i == s.length()) return 1;
        
        char c = s.charAt(i);
        if(c < '1' || c > '9') return 0;
        
        if(s.length() - 1 == i) return 1;
        
        
        
        
        
        if(c > '2' || c == '2' && (i + 1 >= s.length() || s.charAt(i + 1) > '6')){
            return numDecodings(s, i + 1);
        } else {
            return numDecodings(s, i + 2) + numDecodings(s, i + 1);
        }
    }
}