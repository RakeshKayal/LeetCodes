class Solution {

    public int atMostNGivenDigitSet(String[] digits, int n) {

        String a = String.valueOf(n);
        int len = a.length();
        int k = digits.length;

        // count numbers  form  1 to n-1 as it must be valid 
        int shorterCount = 0;
        int pow = 1;
        for (int l = 1; l < len; l++) {
            pow *= k;
            shorterCount += pow;
        }    // 100  len is 3 so upto 2 len all are valid ... 

       //now for  partially  suppose 
        //["1","3","5","7"]  n= 114 so 111 and 113 also valid  find that
        int l = 1;
        int r = (int) Math.pow(k, len);
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canImade(mid, n, digits)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int sameLenCount = (ans == -1) ? 0 : ans;  

        return shorterCount + sameLenCount;
    }

    public boolean canImade(int m, int n, String[] digits) {
        String target = String.valueOf(n);
        int len = target.length();
        int k = digits.length;

        long idx = m - 1;
        char[] built = new char[len];

        for (int pos = len - 1; pos >= 0; pos--) {
            int d = (int) (idx % k);
            built[pos] = digits[d].charAt(0);
            idx /= k;
        }

        String num = new String(built);
        return num.compareTo(target) <= 0;
    }
}