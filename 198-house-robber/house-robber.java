class Solution {
    public int rob(int[] nums) {
        int rob = 0;  // Max money if we ROB the current house
        int skip = 0; // Max money if we SKIP the current house

        for (int money : nums) {
            // 1. If we rob this house, we MUST have skipped the previous house
            int newRob = skip + money;

            // 2. If we skip this house, we keep the best total from the previous house
            int newSkip = Math.max(rob, skip);

            // Update our totals before moving to the next house
            rob = newRob;
            skip = newSkip;
        }

        // Return whichever choice gave us more money at the end of the street
        return Math.max(rob, skip);
    }
}