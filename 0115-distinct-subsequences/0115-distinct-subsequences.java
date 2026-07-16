class Solution {
    public int numDistinct(String s, String t) {

        int a=s.length();
        int b=t.length();

        if(a<b) return 0;
        if(a==b) return s.equals(t)?1:0;

        int dp[][]= new int [a][b];
        for(int it[] : dp){
            Arrays.fill(it,-1);
        }


        return f(0,s,0,t,dp);
        
    }

    public int f(int idx, String s, int id,String t,int [][]dp){

        if(id==t.length()){
            return 1;
        }
        if(idx==s.length() && id!=t.length()){
            return 0;
        }


        if(dp[idx][id]!=-1){
            return dp[idx][id];
        }
        int take=0;
        int not=0;

        if(idx<s.length() && s.charAt(idx)==t.charAt(id)){
            take+=f(idx+1,s,id+1,t,dp);
            not+=f(idx+1,s,id,t,dp);
        }else{
            return dp[idx][id]= f(idx+1,s,id,t,dp);
        }

        return dp[idx][id]= take+not;


    }


}