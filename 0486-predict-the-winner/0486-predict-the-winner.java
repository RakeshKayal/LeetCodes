class Solution {
    public boolean predictTheWinner(int[] nums) {

        int n=nums.length;

        

        return f(0,n-1,0,true,nums);
    }

    public boolean f(int i, int j, int diff, boolean flag, int n[]){

        if(i==j){
            
            int f=flag ? diff+n[i]: diff-n[i];
            return f>=0;
        }
        boolean res;
        if(flag){
            boolean takeS=f(i+1,j,diff+n[i],false,n);
            boolean takeE=f(i,j-1,diff+n[j],false,n);
           res= takeS || takeE;
        }else{

           boolean takeS=f(i+1,j,diff-n[i],true,n);
            boolean takeE=f(i,j-1,diff-n[j],true,n);
            res= takeS && takeE;
        }

            return res;
    }
}