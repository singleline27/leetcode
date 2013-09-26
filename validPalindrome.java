public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) return true;
        
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j) {
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                ++i;
            }
            while(j > -1 && !Character.isLetterOrDigit(s.charAt(j))) {
                --j;
            }
            
            if(i >= s.length() || j <= -1 || i == j) return true;   
            
            if(Character.isDigit(s.charAt(i))) {
                if(!Character.isDigit(s.charAt(j)) || s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            } else {
                if(!Character.isLetter(s.charAt(j)) || Character.toLowerCase(s.charAt(i)) 
                        != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
            }
            ++i;
            --j;
        }
        return true;
    }
}