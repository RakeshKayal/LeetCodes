class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;

        
        int[] prefixGcd = new int[n];
        int maxSoFar = nums[0];

        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxSoFar);
        }

      
        

       
        Arrays.sort(prefixGcd);

      
        long sum = 0;
        int left = 0, right = n - 1;

        while (left < right) {
            sum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return sum;
    }

    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}