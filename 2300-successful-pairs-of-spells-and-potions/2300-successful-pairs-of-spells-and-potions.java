class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {


        int n= spells.length;
        int ans[]= new int[n];
        Arrays.sort(potions);
        int m=potions.length;

        for(int i=0;i<n;i++){

            int lb=f(potions,success,spells[i]);
            if(lb!=m){
                ans[i]=m-lb;
            }else{
                ans[i]=0;
            }

        }
        return ans;
        
    }

    public int f(int []p, long s, int t){

        int l=0;
        int r=p.length;
        while(l<r){
            int mid=(l+r)/2;

            if((long)t*p[mid]>=s){
              r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}