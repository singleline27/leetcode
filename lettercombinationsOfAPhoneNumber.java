public class Solution {
    private ArrayList<String> result;
    private String digits;
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        this.digits = digits;
        result = new ArrayList();
        find(0, new StringBuilder());
        return result;
    }
    
    private void find(int i, StringBuilder sb) {
        if(i == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        char c = digits.charAt(i);
        if(c < '2' || c > '9') {
            find(i + 1, new StringBuilder(sb));
            return;
        }
        
        int num = Character.getNumericValue(c);
        
        char start;
        if(num <= 7) {
            start = (char)('a' + (num - 2) *3);
        } else if(num == 8){
            start = 't';
        } else {
            start = 'w';
        }
        char end = (char)(start + ((num == 7 || num == 9)? 3 : 2));
        
        
        for(char ch = start; ch <= end; ++ch) {
            StringBuilder sb1 = new StringBuilder(sb);
            find(i + 1, sb1.append(ch));
        }
    
    }
}