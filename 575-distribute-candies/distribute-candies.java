
class Solution {
    public int distributeCandies(int[] candyType) {
        int total = candyType.length;
        int canEat = total / 2;

        HashSet<Integer> distinct = new HashSet<>();

        for (int candy : candyType) {
            distinct.add(candy);
        }

        return Math.min(distinct.size(), canEat);
    }
}
