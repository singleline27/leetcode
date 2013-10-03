public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = gas.length;
        if(len == 0) return -1;
        
        int[] remains = new int[len];
        for(int i = 0; i < len; ++i) {
            remains[i] = gas[i] - cost[i];
        }
        
        for(int i = 0; i < len; ++i) {
            if(remains[i] >= 0) {
                int remaining = 0;
                for(int j = i; j < i + len; ++j) {
                    remaining += remains[j % len];
                    if(remaining < 0) {
                        i = Math.max(i, j % len);
                        break;
                    }
                }
                if(remaining >= 0) return i;
            } 
        }
        
        return -1;
    }
}