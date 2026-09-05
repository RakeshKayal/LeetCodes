class Solution {
    static int mod = 1000000007;

    public int sumDecoded(long[] nums) {

      int sum = 0;
for (long it : nums) {
   
    int w = (int) (it % 10);
    
    
    long d = it / 10;
    String s = String.valueOf(d);
    
   
    if (w > s.length()) {
        w = s.length(); 
    }
    
    
    String firstPart = s.substring(0, w);
    String secondPart = s.substring(w);
    
   
    long x = firstPart.isEmpty() ? 0 : Long.parseLong(firstPart);
    long y = secondPart.isEmpty() ? 0 : Long.parseLong(secondPart);
    
   
    long z = power(x, y, mod);
    
 
    sum = (int) ((sum + z) % mod);
}
return sum;
    }


    public long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

}