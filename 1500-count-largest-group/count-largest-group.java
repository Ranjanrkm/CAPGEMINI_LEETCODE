class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;

            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }
        int count = 0;

        for(int size : map.values()) {
            if(size == max) {
                count++;
            }
        }

        return count;
    }
}