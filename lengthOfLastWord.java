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

public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] sec = s.split(" ");
        for(int i = sec.length -1; i >= 0; --i) {
            if(sec[i].length() > 0) return sec[i].length();
        }
        return 0;
    }
}