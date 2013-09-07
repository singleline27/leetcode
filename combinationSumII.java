public class Solution {
    private int[] num;
    private HashSet<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new HashSet();
        
        if(num.length == 0) return new ArrayList(result);
        
        Arrays.sort(num);
        this.num = num;
        find(-1, target, new ArrayList<Integer>());
        
        return new ArrayList(result);
        
    }
    
    private void find(int curIndex, int target, ArrayList<Integer> curr) {
        
        if(target == 0) {
            result.add(curr);
            return;
        }
        
        if(curIndex >= num.length - 1) return;
        int curMax = num[curIndex + 1];
        
        if(curMax > target) return;
        
        for(int i = curIndex + 1; i < num.length; ++i) {
            ArrayList<Integer> thisR = new ArrayList(curr);
            thisR.add(num[i]);
            find(i, target - num[i], thisR);
        }
        
    }
}

