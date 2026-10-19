class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) {
            return true;
        }
        int cnt = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0){
                if((i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    cnt++;
                    if(cnt >= n) {
                        return true;
                    }
                }
            }
        }
        // if(flowerbed.length - 2 >= 2 * n + 1) return true;
        return false;
    }
}