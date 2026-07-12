class Solution {
    static int MOD = (int) 1e9 + 7;

    public int minimumCost(int[] nums, int k) {

        long cost = 0;
        long p = 0;

        long r = k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > r) {
                long deficit = nums[i] - r;
                long h = (deficit + k - 1) / k;

                long term1 = (h % MOD) * (p % MOD) % MOD;

                long half = (h % 2 == 0) ? h / 2 : (h + 1) / 2;
                long other = (h % 2 == 0) ? (h + 1) : h;
                long term2 = (half % MOD) * (other % MOD) % MOD;

                cost = (cost + term1 + term2) % MOD;

                p += h;
                r = r + h * (long) k - nums[i];
            } else {
                r = r - nums[i];
            }
        }

        return (int) cost;

    }
}