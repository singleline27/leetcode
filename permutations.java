public class Solution {
    private int[] num;
    private ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList();
        
        if(num.length == 0) return result;
        
        HashMap<Integer, Integer> map = new HashMap();
        for(int val : num) {
            int count = 1;
            if(map.containsKey(val)) {
               count = map.get(val);
               count ++;
            }
            map.put(val, count);
        }
        
        find(new ArrayList<Integer>(), map);
        
        return result;
    }
    
    private void find(ArrayList<Integer> curr, HashMap<Integer, Integer> map) {
        
        if(map.size() == 0) {
            result.add(curr);
            return;
        } 
        
        for(int val : map.keySet()) {
            ArrayList<Integer> tmp = new ArrayList(curr);
            HashMap<Integer, Integer> tmpMap = new HashMap(map);
            tmp.add(val);
            int count = map.get(val);
            if(count == 1) {
                tmpMap.remove(val);
            } else {
                tmpMap.put(val, count - 1);
            }
            find(tmp, tmpMap);
            
        }
    }
}