public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder("1");
        for(int i = 0; i < n - 1; ++i) {
            sb = generateNext(sb);
        }
        
        return sb.toString();
    }
    
    private StringBuilder generateNext(StringBuilder sb) {
        
        int count = 1;
        char curr = sb.charAt(0);
        StringBuilder newStr = new StringBuilder("");
        
        for(int i = 1; i < sb.length(); ++i) {
            
            if(sb.charAt(i) == sb.charAt(i - 1)) {
                ++count;
            } else {
                newStr.append(count).append(curr);

                curr = sb.charAt(i);
                count = 1;
            }
        }
        
        return newStr.append(count).append(curr);
    }
}