public class Solution {
    private ArrayList<String> result;
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12) return result;
        makeAddress(s, 0, 0, "");
        return result;
    }
    
    private void makeAddress(String s, int index, int section, String curr) {
        int len = s.length();
        int remain = len - index;
        if(section == 3) {
            if(remain >= 1 && remain <= 3) {
                if(s.charAt(index) == '0' && remain != 1 || Integer.parseInt(s.substring(index)) > 255) {
                    return;
                }
                result.add(curr + s.substring(index));
            }    
            return;
        }
        
        int start = Math.max(1, remain - (3 - section) *3);
        int end = Math.min(3, remain - (3 - section) * 1);
        if(s.charAt(index) == '0') {
            end = 1;
        }
        if(end == 3) {
            if(Integer.parseInt(s.substring(index, index + 3)) > 255) {
                end = 2;
            }
        }
        
        for(int i = start; i <= end; ++i) {
            makeAddress(s, index + i, section + 1, curr + s.substring(index, index + i) + ".");
        }
    }
}