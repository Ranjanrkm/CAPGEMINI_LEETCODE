class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int currentGcd = 0;

            for (int j = i; j < n; j++) {
                // Optimization: If nums[j] is not divisible by k, no subarray 
                // including nums[j] can ever have a GCD of k.
                if (nums[j] % k != 0) {
                    break;
                }

                currentGcd = gcd(currentGcd, nums[j]);

                if (currentGcd == k) {
                    count++;
                }
            }
        }

        return count;
    }

    // Standard Euclidean algorithm to find GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}