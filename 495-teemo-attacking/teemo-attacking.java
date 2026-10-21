class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int total = 0;
        for(int i = 0; i < n - 1; i ++) {
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        total += duration;
        return total;
    }
}