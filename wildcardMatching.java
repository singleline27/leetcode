public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s.length();
        int len2 = p.length();
        
        int i = 0;
        int j = 0;
        int lastI = -1;
        int lastJ = -1;
        while(i < len1) {
            char c = s.charAt(i);
            char curr = ' ';
            if(j < len2) curr = p.charAt(j);

            if(c == curr || curr == '?') {
                ++i;
                ++j;
            } else if(curr == '*'){
                while(j < len2 && p.charAt(j) == '*') ++j;
                if(j == len2) return true;
                    
                char next = p.charAt(j);
                while(i < len1 && next != '?' && s.charAt(i) != next) ++i;

                lastI = i;
                lastJ = j;
                
            } else if((j == len2 || curr != c) && lastI != -1) {
                j = lastJ;
                i = ++lastI;
                
            } else {
                return false;
            }
            
        }   
        if(i < len1) return false;
        while(j < len2) {
            if(p.charAt(j) != '*') return false;
            ++j;
        }
        
        return true;
    }
}