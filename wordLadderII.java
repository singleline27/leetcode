public class Solution {
    private HashSet<String> dict;
    private String end;
    private int maxLen;
    private ArrayList<ArrayList<String>> result;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<String>>();
        this.dict = dict;
        this.end = end;
        maxLen = -1;

        ArrayList<String> q = new ArrayList<String>();
        HashSet<String> used = new HashSet<String>();
        q.add(start);
        used.add(start);
        findResult(q, used);
        
        Iterator<ArrayList<String>> it = result.iterator();
        while(it.hasNext()) {
            ArrayList<String> list = it.next();
            if(list.size() > maxLen) {
                it.remove();
            }
        }
        return result;
    }
    
    private void findResult(ArrayList<String> q, HashSet<String> used) {
        if(maxLen > 0 && q.size() >= maxLen) {
            return;
        }
        
        String last = q.get(q.size() - 1);
        for(String word : dict) {
            
            if(!used.contains(word) && isNext(word, last)) {
                ArrayList<String> nq = new ArrayList<String>(q);
                HashSet<String> nused = new HashSet<String>(used);
                nq.add(word);
                nused.add(word);
                
                if(word.equals(end)) {
                    result.add(nq);
                    if(maxLen < 0) {
                        maxLen = nq.size();
                    } else {
                        maxLen = Math.min(maxLen, nq.size());
                    }
                } else {
                    findResult(nq, nused);
                }
            }
        }
        
    }
    
    private boolean isNext(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        
        boolean found = false;
        for(int i = 0; i < str1.length(); ++i) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(c1 != c2) {
                if(found) return false;
                found = true;
            }
        }
        return found;
    }
}



public class Solution {
    private HashSet<String> dict;
    private HashMap<String, ArrayList<String>> map;
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        map = new HashMap<String, ArrayList<String>>();
        this.dict = dict;
        buildMap(start.length());
        
        ArrayList<String> q = new ArrayList<String>();
        q.add(start);
                
        ArrayList<ArrayList<String>> currArrs = new ArrayList<ArrayList<String>>();
        currArrs.add(q);
        
        HashSet<String> remains = new HashSet<String>(dict);
        remains.remove(start);
        boolean done = false;
        
        while(!done) {
            ArrayList<ArrayList<String>>  newArrs = new ArrayList<ArrayList<String>>();
            HashSet<String> nextWords = new HashSet<String>();
            
            for(ArrayList<String> curr : currArrs)  {
                String last = curr.get(curr.size() - 1);
                ArrayList<String> list = map.get(last);
                
                for(String next: list) {
                    
                    if(next.equals(end) || remains.contains(next)) {
                        if(next.equals(end)) {
                            done = true;
                        }
                        
                        nextWords.add(next);
                        ArrayList<String> newList = new ArrayList<String>(curr);
                        newList.add(next);
                        newArrs.add(newList);
                    }
                }
            }
            
            if(nextWords.size() == 0) done = true;
            remains.removeAll(nextWords);
            currArrs = newArrs;
        }
        
        for(ArrayList<String> list : currArrs) {
            String last = list.get(list.size() - 1);
            if(last.equals(end)) {
                result.add(list);
            }
        }
        return result;
    }
    
    private void buildMap(int len) {
        HashSet<String> used = new HashSet<String>(dict);
        for(String curr : dict) {
            ArrayList<String> list = new ArrayList<String>();
            for(int i = 0; i < len; ++i) {
                StringBuilder sb = new StringBuilder(curr);
                for(char c = 'a'; c <= 'z'; ++c) {
                    sb.setCharAt(i, c);
                    String str = sb.toString().intern();
                    if(str.intern() != curr.intern() && dict.contains(str)) {
                        list.add(str);
                    }
                }
            }
            map.put(curr, list);
        }
    }
}