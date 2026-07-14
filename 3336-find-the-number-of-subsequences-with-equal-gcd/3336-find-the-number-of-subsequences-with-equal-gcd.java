class Solution {
    int mod = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int dp[][][] = new int[n + 1][max + 1][max + 1];
        for (int[][] it : dp)
            for (int[] t : it)
                Arrays.fill(t, -1);

        return f(nums, 0, 0, 0, dp);
    }

    public int f(int n[], int id, int g1, int g2, int dp[][][]) {

        if (id == n.length) {
            if (g1 != 0 && g2 != 0) {
                return g1 == g2 ? 1 : 0;
            }
            return 0;
        }

        if (dp[id][g1][g2] != -1) {
            return dp[id][g1][g2];
        }

        long skip = f(n, id + 1, g1, g2, dp);
        long s1   = f(n, id + 1, gcd(g1, n[id]), g2, dp);
        long s2   = f(n, id + 1, g1, gcd(g2, n[id]), dp);

        return dp[id][g1][g2] = (int) ((skip + s1 + s2) % mod);
    }

    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}