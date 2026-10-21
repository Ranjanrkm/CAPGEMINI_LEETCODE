class Solution {
    public int distributeCandies(int[] candyType) {
        int total = candyType.length;
        int caneat = total / 2;

        HashSet<Integer> dif = new HashSet<>();

        for(int cand : candyType) {
            dif.add(cand);
        }

        if(dif.size() <= caneat) return dif.size();
        return caneat;
    }
}