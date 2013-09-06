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