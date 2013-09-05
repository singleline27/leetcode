public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        
        if(numRows <= 0) return result;
        
        ArrayList<Integer> first = new ArrayList<Integer>();
        result.add(first);
        first.add(1);
        
        ArrayList<Integer> last = first;
        ArrayList<Integer> curr;
        for(int i = 2; i <= numRows; ++i) {
            curr = new ArrayList<Integer>(i);
            result.add(curr);
            
            curr.add(0, 1);
            
            for(int j = 1; j < i - 1; ++j) {
                
                int sum = last.get(j-1) + last.get(j);
                curr.add(j, sum);
                
            }
            curr.add(i - 1, 1);
            last = curr;
        }
        
        return result;
    }
}