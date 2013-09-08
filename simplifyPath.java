public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] sec = path.split("/");
        int start = 0;
        for(int i = 0; i < sec.length; ++i) {
            
            if(sec[i].equals(".")) {
                sec[i] = "";
            }
            
            if(sec[i].equals("..")) {
                sec[i] = "";
                
                int j = i - 1;
                while(j >= 0 && sec[j].equals("")) --j;
                
                if(j < 0) start = i;
                else sec[j] = "";
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < sec.length; ++i) {
            if(sec[i].length() != 0) {
                sb.append("/").append(sec[i]);
            }
        }
        
        if(sb.length() == 0) {
            sb.append("/");
        }
        
        return sb.toString();
    }
}