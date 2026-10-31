import java.util.*;

class Solution {
    public int scheduleCourse(int[][] courses) {
        // 1. Sort courses by their lastDay in ascending order
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        // Max-heap to keep track of the durations of the courses we've taken
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        int totalTime = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            // Add the current course
            totalTime += duration;
            maxHeap.offer(duration);

            // If total time exceeds the current deadline, drop the longest course taken so far
            if (totalTime > lastDay) {
                totalTime -= maxHeap.poll();
            }
        }

        // The number of courses remaining in the heap is the maximum we can take
        return maxHeap.size();
    }
}