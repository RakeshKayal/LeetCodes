class Solution {
    private Map<String, Integer> memo;
    public int minOperations(int[] nums, int x) {
        //  memo = new HashMap<>();

         int n = nums.length;

        // int xs = f(0, n - 1, x, nums);

        // if (xs == Integer.MAX_VALUE)
        //     return -1;
        // return xs;

        int s=0;
        for (int it: nums){
            s+=it;
        }

        int t= s-x;

        if(t<0) return -1;
        if(t==0) return n;

        int i=0;
        int j=0;
        int s1=0;
        int maxLen = -1;
        while(j<n){
            s1+=nums[j];
            
            while(s1>t && i<j){
                s1-=nums[i];
                i++;
            }
            if(s1==t){
                maxLen=Math.max(maxLen,j-i+1);

            }
            
                j++;
            

        }
        return maxLen==-1 ?-1 : n-maxLen;





    }

    public int f(int i, int j, int x, int[] nums) {

        if (x == 0)
            return 0;

        if (x < 0 || i > j || i >= nums.length || j < 0) {
            return Integer.MAX_VALUE;
        }

        String key = i + "," + j + "," + x;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int left = f(i + 1, j, x - nums[i], nums);
        if (left != Integer.MAX_VALUE) {
            left += 1;
        }

        int right = f(i, j - 1, x - nums[j], nums);
        if (right != Integer.MAX_VALUE) {
            right += 1;
        }
         int ans = Math.min(left, right);
        
        
        memo.put(key, ans);
        return ans;

    }
}