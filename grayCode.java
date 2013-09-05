public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList();

        
        HashSet<String> set = new HashSet();
        
        boolean undone = true;
        int[] curr = new int[n];
        set.add(Arrays.toString(curr));
        addVal(curr, result);
        
        while(undone) {
            undone = false;
            for(int i = 0; i < n; ++i) {
                curr[i] = (curr[i] == 0)? 1:0;
                String arrStr = Arrays.toString(curr);
                if(!set.contains(arrStr)) {
                    set.add(arrStr);
                    addVal(curr, result);
                    undone = true;
                    break;
                } else {
                    curr[i] = (curr[i] == 0)? 1:0;
                }
                
            }
        }
        return result;
    }
    
    private void addVal(int[] array, ArrayList<Integer> result) {
        int sum = 0;
        for(int i = 0; i < array.length; ++i) {
            if(array[i] == 1) {
                sum += Math.pow(2, i); 
            }
        }
        result.add(sum);
    }
}