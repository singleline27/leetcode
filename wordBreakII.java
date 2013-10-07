public class Solution {
    private ArrayList<String> result;
    private Set<String> dict;
    private int len;
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        result = new ArrayList<String>();
        if(dict.size() ==0 || s.length() == 0) return result;
        this.dict = dict;
        len = -1;       
        for(String word: dict) len = Math.max(len, word.length()); 
        doWork(s, s.length(), new StringBuilder());
        return result;
    }
    
    private void doWork(String s, int index, StringBuilder sb) {
        if(index == 0) {
            result.add(sb.toString().trim());
            return;
        }
        
        int i = Math.min(len, index);
        while(i > 0) {
            String sub = s.substring(index - i, index);
            if(dict.contains(sub)) {
                StringBuilder sb1 = new StringBuilder(sub);
                sb1.append(" ").append(sb);
                doWork(s, index - i, sb1);
            }
            --i;
        }
    }
}