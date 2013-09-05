public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> curr = new ArrayList();
        ArrayList<Integer> last = new ArrayList();
        if(rowIndex < 0) return curr;
        
        curr.add(1);
        last = curr;
        for(int i = 1; i <= rowIndex; ++i) {
            curr = new ArrayList();
            curr.add(0, 1);
            for(int j = 1; j < i; ++j) {
                curr.add(j, last.get(j-1) + last.get(j));
            }
            curr.add(i, 1);
            
            last = curr;
        }
        
        return curr;
        
    }
}