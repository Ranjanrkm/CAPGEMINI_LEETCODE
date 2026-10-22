class Solution {
    public int thirdMax(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int n = set.size();
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        if(list.size() >= 3) return list.get(2);
        return list.get(0);
    }
}