public class Solution {

    
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s3.length() != s1.length() + s2.length()) return false;
        
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }
    
    public boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {

        int i = i1;
        int j = i2;
        int k = i3;
        
        while(i < s1.length() || j < s2.length()) {
            
            if(i < s1.length() && j < s2.length()) {
            
                if(s1.charAt(i) != s2.charAt(j)) {
                    if(s1.charAt(i) == s3.charAt(k)) {
                        ++i;
                        ++k;
                    } else if(s2.charAt(j) == s3.charAt(k)) {
                        ++j;
                        ++k;
                    } else {
                        return false;
                    }
                } else {
                    if(s1.charAt(i) != s3.charAt(k)) {
                        return false;
                    } else {
                        return isInterleave(s1, i + 1, s2, j, s3, k +1 ) || isInterleave(s1, i, s2, j + 1, s3, k +1 );
                    }
                }
            } else if(i < s1.length()){
                return s1.substring(i).equals(s3.substring(k));
            } else {
                return s2.substring(j).equals(s3.substring(k));
            }
        }
        return true;
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