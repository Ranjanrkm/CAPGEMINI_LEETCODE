class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Stores how many times each remainder (0 to k - 1) has occurred
        int[] remainderCount = new int[k];
        
        // Base case: an empty prefix has a sum of 0 (remainder 0)
        remainderCount[0] = 1;

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            // In Java, % can be negative (e.g., -2 % 5 = -2).
            // Adding k and taking % k again forces the remainder into [0, k - 1].
            int rem = ((prefixSum % k) + k) % k;

            // Every previous prefix with the exact same remainder forms a 
            // valid subarray ending at the current element.
            count += remainderCount[rem];

            // Record this remainder for future elements
            remainderCount[rem]++;
        }

        return count;
    }
}