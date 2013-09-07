public class Solution {
    private int[] candidates;
    private ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList();
        
        if(candidates.length == 0) return result;
        
        Arrays.sort(candidates);
        this.candidates = candidates;
        find(0, target, new ArrayList<Integer>());
        return result;
        
    }
    
    private void find(int curIndex, int target, ArrayList<Integer> curr) {
        
        if(target == 0) {
            result.add(curr);
            return;
        }
        
        if(curIndex >= candidates.length) return;
        int curMax = candidates[curIndex];
        
        if(curMax > target) return;
        
        for(int i = curIndex; i < candidates.length; ++i) {
            ArrayList<Integer> thisR = new ArrayList(curr);
            thisR.add(candidates[i]);
            find(i, target - candidates[i], thisR);
        }
        
    }
}