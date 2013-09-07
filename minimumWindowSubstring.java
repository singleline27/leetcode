public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(S.length() == 0 || T.length() == 0 || S.length() < T.length()) return "";
        
        int start = S.length() - 1;
        int len = -1;
        
        HashMap<Character, Integer> target = new HashMap();
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < T.length(); ++i) {
            char c = T.charAt(i);
            if(!target.containsKey(c)) {
                target.put(c, 1);
                map.put(c, 0);
            } else {
                int count = target.get(c);
                target.put(c, count + 1);
            }
        }
        
        HashMap<Character, Integer> copy = new HashMap(target);
        int left = S.length() - 1;
        for(int i = S.length() - 1; i >= 0; --i) {
            char c = S.charAt(i);
            if(!target.containsKey(c)) {
                continue;
            }
            
            if(map.containsKey(c)) {
                int count = map.get(c) + 1;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
            
            if(copy.containsKey(c)) {
                int count = copy.get(c) - 1;
                copy.put(c, count);
                if(count == 0) copy.remove(c);
                
                if(copy.size() == 0) {
                    start = i;
                    left = i - 1;
                    len = S.length() - i;
                    break;
                }
            }
        }
        
        if(len == -1) return "";
        
        if(T.length() < 2) {
            return T;
        }
        
        int curlen = len;
        for(int i = S.length() - 2; i >= T.length() - 1; --i) {
            char c = S.charAt(i + 1);
            
            if(!target.containsKey(c)) {
                --curlen;
                
                if(curlen < len) {
                    len = curlen;
                    start = left + 1;
                }
                continue;
            }
            
            int count = map.get(c);
            
            if(count > target.get(c)) {
                map.put(c, count - 1);
                --curlen;
                if(curlen < len) {
                    len = curlen;
                    start = left + 1;
                }
            } else {
                while(left >= 0) {
                    char ch = S.charAt(left);
                    if(target.containsKey(ch) && ch != c) {
                        int cnt = map.get(ch) + 1;
                        map.put(ch, cnt);
                    }
                    
                    if(ch == c) break;
                    --left;
                }
                
                if(left < 0) break;
                --left;
                
                curlen = i - left;
                if(curlen < len) {
                    len = curlen;
                    start = left + 1;
                }
            }
            
            
        }
        
        return S.substring(start, start + len);
    }
}