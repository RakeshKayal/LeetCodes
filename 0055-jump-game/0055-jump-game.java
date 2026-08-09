class Solution {
    public boolean canJump(int[] nums) {


        int n= nums.length;
        if(n==0 || n==1) return  true;

        // int dp[]= new int[n+1];
        // Arrays.fill(dp,-1);
        


        // return f(0, nums,dp);


        int maxjum[]= new int[n];
        for(int i=0;i<n;i++){
            maxjum[i]=i+nums[i];
        }

        int cur=0;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,maxjum[i]);

            if(cur==i){
                cur=max;
            }
            if(i>cur) return false;

        }
        return cur>=n-1;
        
    }

    public boolean f(int idx, int []nums,int[] dp){

        if(idx>=nums.length-1){
            return true;
        }
        if(dp[idx]!=-1){
            return dp[idx]==1 ?true : false;
        }
        int maxReach = idx + nums[idx];

    for (int i = idx + 1; i <= maxReach; i++) {
        if (f(i, nums,dp)) {
             dp[idx]=1; 
             return true;
        }
    }

    dp[idx]=0;
    return false;   
    }
}