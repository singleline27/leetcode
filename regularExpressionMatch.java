public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0 && p.length() == 0) return true;
        int len1 = s.length();
        int len2 = p.length();
        
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2) {
            char c1 = s.charAt(i);
            char curr = p.charAt(j);
            char next = ' ';
            if(j + 1 < len2) {
                next = p.charAt(j + 1);
            }
            if(c1 == curr || curr == '.') {
                if(next != '*') {
                    ++i;
                    ++j;
                }
                else {
                    if(isMatch(s.substring(i + 1), p.substring(j))) {
                        return true;
                    } else {
                        if(j >= p.length()) {
                            return false;
                        } else {
                            j += 2;
                        }
                    }
                }
            } else {
                if(next == '*') {
                    j += 2;  
                } else {
                    return false;
                }
            }
            
        }   
        if(i < len1) return false;
        while(j < len2) {
            char curr = p.charAt(j);
            if(j + 1 >= p.length()) return false;
            char next = p.charAt(j + 1);
            
            if(next != '*') return false;
            j += 2;
        }
        
        return true;
    }
}