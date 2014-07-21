public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) return new int[]{0, 0};
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted);
        
        int i = 0;
        int j = sorted.length - 1;
        while (i < j) {
            int sum = sorted[i] + sorted[j];
            if (sum < target) {
                ++ i;
            } else if(sum > target) {
                -- j;
            } else {
                int first = sorted[i];
                int second = sorted[j];
                int index1 = 0;
                int index2 = 0;
                for(int k = 0; k < numbers.length; ++k) {
                    if(index1 == 0 && numbers[k] == first) {
                        index1 = k + 1;
                    } else if(index2 == 0 && numbers[k] == second) {
                        index2 = k + 1;
                    }
                }
                int[] result = new int[]{index1, index2};
                Arrays.sort(result);
                return result;
            }
        }
        
        return new int[]{0, 0};
    }
}