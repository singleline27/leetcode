public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList();
        
        result.add(0);
        
        for(int i = 0; i < n; ++i) {
            int len = result.size();
            int base = 1 << i;
            
            for(int j = 1; j <= len; ++j) {
                result.add(base + result.get(len - j));
            }
            
        }
        return result;
    }
    
}