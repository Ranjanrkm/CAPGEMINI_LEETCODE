class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int alice_total = 0;
        int bob_total = 0;

        for(int candy : aliceSizes) {
            alice_total += candy;
        }
        for(int candy : bobSizes) {
            bob_total += candy;
        }

        int diff = (alice_total - bob_total) / 2;
        HashSet<Integer> set = new HashSet<>();

        for(int candy : bobSizes){
            set.add(candy);
        }
        for(int candy : aliceSizes){
            int bobCandy = candy - diff;

            if(set.contains(bobCandy)){
                return new int[]{candy, bobCandy};
            }
        }
        return new int[]{};
    }
}