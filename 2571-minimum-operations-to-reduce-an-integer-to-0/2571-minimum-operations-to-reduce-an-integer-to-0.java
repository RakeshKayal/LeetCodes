class Solution {
    public int minOperations(int n) {
        
       

     return f(n);
    }

    public int f(int n){
         if(n > 0 && (n & (n - 1)) == 0){
            return 1;
        }

      int power = 1;
        while (power < n) {
            power <<= 1;
        }

        int lower = power >> 1;
        int upper = power;

        int res=1+Math.min(f(n-lower),f(upper-n));
        return res;
    }
}