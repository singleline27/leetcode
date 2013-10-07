// Type your C++ code and click the "Run Code" button!
// Your code output will be shown on the left.
public class Solution {
    private Set<String> dict;
    private int len;
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        this.dict = dict;
        len = -1;
        for(String word: dict) len = Math.max(len, word.length());
        return doWork(s, s.length());
    }
    
    private boolean doWork(String s, int index) {
        if(0 == index) return true;
        int i = Math.min(len, index);
        while(i > 0) {
            String substr = s.substring(index - i, index);
            if(dict.contains(substr) && doWork(s, index - i)) return true;
            --i;
        }
        return false;
    }
}