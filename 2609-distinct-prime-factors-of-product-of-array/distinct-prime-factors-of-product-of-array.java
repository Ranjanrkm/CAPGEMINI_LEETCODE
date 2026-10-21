class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primeFactors = new HashSet<>();

        for(int num : nums) {
            for(int p = 2; p * p <= num; p++) {
                if(num % p == 0) {
                    primeFactors.add(p);

                    while(num % p == 0) {
                        num /= p;
                    }
                }
            }
            if(num > 1) {
                primeFactors.add(num);
            }
        }
        return primeFactors.size();

    }
}