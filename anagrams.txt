public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs == null || strs.length == 0) {
            return new ArrayList<String>();
        }
        
        HashMap<String, ArrayList<String>> map = new HashMap<String,  ArrayList<String>>();
        
        for(String str : strs) {
            
            ArrayList<String> list;
            String key = sortString(str);
            if(!map.containsKey(key)) {
                list = new ArrayList<String>();
                map.put(key, list);
            } else {
                list = map.get(key);
            }
            list.add(str);
            
        }
        
        ArrayList<String> result = new ArrayList<String>();
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> list = entry.getValue();
            if(list.size() > 1) {
                result.addAll(list);
            }
        }

        return result;
    }
    
    private String sortString(String str) {

        // empty string or single character
        if(str.length() <= 1) return str;
        
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        
        //chars.toString() wont't work
        return new String(chars);
    }
}


