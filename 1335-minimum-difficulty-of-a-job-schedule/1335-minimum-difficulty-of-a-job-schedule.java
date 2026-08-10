class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {

        int n=jobDifficulty.length;
        // if(n==d){
        //     int sum=0;
        //     for(int it: jobDifficulty){
        //         sum+=it;
        //     }
        //     return sum;
        // }
        if(n<d) return -1;
        int dp[][]=new int[n+1][d+1];
        for(int it[]: dp){
           Arrays.fill(it,-1);
        }
        

    int m= f(0, d, jobDifficulty,dp);
    
    return m==Integer.MIN_VALUE ? -1 :m;

    }

    public int f(int idx, int d, int[] j,int dp[][]){

        if(d==1){
            int sum=0;
            for(int i=idx;i<j.length;i++){
                sum=Math.max(sum,j[i]);
            }
            return sum;
        }

        if(dp[idx][d]!=-1){
            return dp[idx][d];
        }

        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=idx;i<(j.length-d)+1;i++){
            max=Math.max(max,j[i]);
            min=Math.min(min,max+f(i+1,d-1,j,dp));
        }
        return dp[idx][d]=min;
    }

    

}