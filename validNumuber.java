public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String trimed = s.trim();
        
        int i = 0;
        boolean seenE = false;
        boolean seenDot = false;
        int len = trimed.length();
        
        if(len == 0) return false;
        while(i < len) {
            char c = trimed.charAt(i);
            if(c >= '0' && c <= '9') {
                ++i;
                continue;
            }
            
            if(c == '.') {
                if(seenDot) {
                    return false;
                }
                
                if(len == 1 || (i-1<0 || !isNum(trimed.charAt(i-1))) && (i+1>=len || !isNum(trimed.charAt(i+1)))) {
                    return false;
                }
                
                if(seenE) return false;
                seenDot = true;
            } else if(c == 'e' || c == 'E') {
                if(seenE) {
                    return false;
                }
                
                if(i == 0 || i == len - 1) return false;
                
                if((trimed.charAt(i-1)!='.' && !isNum(trimed.charAt(i-1))) || 
                    !isNum(trimed.charAt(i+1)) && trimed.charAt(i+1)!='+' && trimed.charAt(i+1)!='-') {
                    return false;
                }
                seenE = true;
            } else if(c == '+' || c == '-'){
                if(i == len - 1) return false;
                
                
                if(i != 0 && (trimed.charAt(i-1)!= 'e'&&trimed.charAt(i-1)!='E')) {
                    return false;
                }
            } else {
                return false;
            }
            
            ++i;
            
        }
        
        return true;
    }
    
    private boolean isNum(char c) {
        return c >= '0' && c <='9';
    }
}