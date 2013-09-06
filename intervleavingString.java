public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length();
        int n = s2.length();
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        
        for(int i = 1; i <= m; ++i) {
            
            if(s1.charAt(i-1) == s3.charAt(i-1))
                dp[i][0] = true;
            else break;
        }
        
        for(int j = 1; j <= n; ++j) {
            
            if(s2.charAt(j-1) == s3.charAt(j-1))
                dp[0][j] = true;
            else break;
        }
        
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j] || s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]) {
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[m][n];
    }

}

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length() + s2.length() != s3.length()) return false;
        
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }
    
    private boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
        
        if(i1 >= s1.length()) return s2.substring(i2).equals(s3.substring(i3));
        
        if(i2 >= s2.length()) return s1.substring(i1).equals(s3.substring(i3));
        
        return ( s1.charAt(i1) == s3.charAt(i3) && isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1))
         || (s2.charAt(i2) == s3.charAt(i3) && isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1));
    }
}

public class Solution {
    
    private class Triple{
        public int x;
        public int y;
        public int z;
        
        public Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
    };
    
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s3.length() != s1.length() + s2.length()) return false;
        
        Stack<Triple> s = new Stack();    
        
        int i = 0, j = 0, k = 0;
        
        while(i < s1.length() || j < s2.length()) {
        
            if(i < s1.length() && j < s2.length()) {
                if(s1.charAt(i) == s2.charAt(j)) {
                
                    if(s1.charAt(i) == s3.charAt(k)) {
                        s.push(new Triple(i, j + 1, k + 1));
                    
                        ++i;
                        ++k;
                    } else {
                        if(s.size() == 0) return false;
                    
                        Triple p = s.pop();
                        i = p.x;
                        j = p.y;
                        k = p.z;
                    }
                } else if(s1.charAt(i) == s3.charAt(k)) {
                    ++i;
                    ++k;
                } else if(s2.charAt(j) == s3.charAt(k)) {
                    ++j;
                    ++k;
                } else {
                    if(s.size() == 0) return false;
                
                    Triple p = s.pop();
                    i = p.x;
                    j = p.y;
                    k = p.z;
                }
            } else {
                
                if(i < s1.length()) {
                    while(i < s1.length()) {
                        if(s1.charAt(i) != s3.charAt(k)) {
                            if(s.size() == 0) return false;
                            Triple p = s.pop();
                            i = p.x;
                            j = p.y;
                            k = p.z;
                            break;
                        } else {
                            ++i;
                            ++k;
                        }
                    }
                } else {
        
                    while(j < s2.length()) {
                        if(s2.charAt(j) != s3.charAt(k)) {
                            if(s.size() == 0) return false;
                            Triple p = s.pop();
                            i = p.x;
                            j = p.y;
                            k = p.z;
                            break;
                        } else {
                            ++j;
                            ++k;
                        }
                    }
                }
                
            }
        }
        
        
        return true;
    }
}