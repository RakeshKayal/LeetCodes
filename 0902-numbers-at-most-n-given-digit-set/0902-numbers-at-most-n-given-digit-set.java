class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int k = digits.length;
        long ans = 0;

        // all numbers with fewer digits than n are automatically <= n
        long pow = 1;
        for (int l = 1; l < len; l++) {
            pow *= k;
            ans += pow;
        }

        // total combinations of length == len
        long total = 1;
        for (int i = 0; i < len; i++) total *= k;

        long l = 0, r = total - 1, best = -1;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (canImade(mid, len, digits, s)) {
                best = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (best != -1) ans += (best + 1);

        return (int) ans;
    }

    
    private boolean canImade(long idx, int len, String[] digits, String s) {
        int k = digits.length;
        char[] built = new char[len];
        long x = idx;
        for (int pos = len - 1; pos >= 0; pos--) {
            int d = (int) (x % k);
            built[pos] = digits[d].charAt(0);
            x /= k;
        }
        String num = new String(built);
        return num.compareTo(s) <= 0; 
    }
}