public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        generate(S, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void generate(int[] S, int index, ArrayList<Integer> curr) {
        if(index == S.length) {
            result.add(curr);
            return;
        }
        int value = S[index];
        ArrayList<Integer> curr1 = new ArrayList<Integer>(curr);
        ArrayList<Integer> curr2 = new ArrayList<Integer>(curr);
        curr2.add(value);
        generate(S, index + 1, curr1);
        generate(S, index + 1, curr2);
    }
}