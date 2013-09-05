public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        
        int[] result = new int[a.length() + b.length()];
        
        int carry = 0;
        
        int i = 0;
        int minLen = Math.min(a.length(), b.length());
        while(i < minLen) {
            int sum = Character.getNumericValue(a.charAt(a.length() - 1 - i)) + Character.getNumericValue(b.charAt(b.length() - 1 - i)) + carry;
            if(sum >= 2) {
                sum -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            
            result[i++] = sum;
            
        }

    
        while(i < a.length()) {
            int sum = Character.getNumericValue(a.charAt( a.length() -1 - i)) + carry;
            if(sum >= 2) {
                sum -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            
            result[i++] = sum;
            
        }
        
        while(i < b.length()) {
            int sum = Character.getNumericValue(b.charAt(b.length() -1 - i)) + carry;
            if(sum >= 2) {
                sum -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            
            result[i++] = sum;
            
        }
        
        if(carry == 1) {
            result[i] = 1;
        }
        
        StringBuilder sb = new StringBuilder();
        i = result.length -1;
        while(i >= 0 && result[i] == 0) --i;
        
        if(i < 0) {
            return "0";
        }
        
        while(i >= 0) {
            sb.append(result[i--]);
        }
        
        return sb.toString();
    }
}