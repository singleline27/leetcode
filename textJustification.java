public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
    
        if(words.length == 0) return result;
        
        int i = 0;
        boolean done = false;
        while(!done) {

            int start = i;
            StringBuilder sb = new StringBuilder();
            sb.append(words[i++]);
            int len = sb.length();
            int num = 1;            
            while(i < words.length) {
                if(sb.length() + words[i].length() + 1 <= L) {
                    sb.append(" ");
                    sb.append(words[i]);
                    len += words[i].length();
                    ++num;
                    ++i;
                } else {
                    break;
                }
            }
            
            if(i == words.length) {
                done = true;
                int index = sb.length();
                for(int k = index; k < L; ++k) {
                    sb.append(" ");
                }
                result.add(sb.toString());
            } else {
                int space = L - len;
                if(num > 1) {
                    int base = space / (num - 1);
                    int remain = space % (num - 1);
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append(words[start]);
                    for(int j = start + 1; j < i; ++j) {
                        
                        for(int k = 0; k < base; ++k) {
                            sb1.append(" ");                            
                        }
                        if(j <= start + remain) {
                            sb1.append(" ");                            
                        }  
                        
                        sb1.append(words[j]);
                    }
                    result.add(sb1.toString());
                } else {
                    int index = sb.length();
                    for(int k = index; k < L; ++k) {
                        sb.append(" ");
                    }
                    result.add(sb.toString());
                }
            }
        }
        
        return result;
    }
}