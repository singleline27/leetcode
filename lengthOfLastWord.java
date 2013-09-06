public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = s.length() - 1;
        
        while(i >=0 && s.charAt(i) == ' ') --i;
        
        if(i < 0) return 0;
        
        int count = 0;
        
        while(i >= 0 && s.charAt(i) != ' ') {
            ++count;
            --i;
        }
        
        return count;
    }
}