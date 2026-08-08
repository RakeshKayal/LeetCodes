class Solution {
    public boolean canCross(int[] stones) {
     
     if(stones[1]!=1) return false;


     

        int n= stones.length;
        int dp[][]= new int[n+1][n+1];
        for(int it[]: dp){
            Arrays.fill(it,-1);
        }

        return f(1,1,stones,dp);
        
    }

    public boolean f(int idx, int k, int[] stones, int [][] dp){

        if(idx==stones.length-1){
            return true;
        }

        if(dp[idx][k]!=-1){
            return dp[idx][k]==1 ? true : false;
        }

        boolean res = false;
    for (int dk = -1; dk <= 1; dk++) {
        int newK = k + dk;
        if (newK <= 0) continue; 
        int target = stones[idx] + newK;
        int next = bs(idx, target, stones);
        if (next != -1 && f(next, newK, stones,dp)) {

            res=true;
            break;
          
        }
    }

    if(k>=0) dp[idx][k]=(res==true) ? 1: 0;
    return res;

    }
    public int bs(int l, int v, int []s){

        int r= s.length-1;

        while(l<=r){
            
            int mid=(l+r)/2;
            if(s[mid]==v){
                return mid;
            }else if(s[mid]> v){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    } 
}