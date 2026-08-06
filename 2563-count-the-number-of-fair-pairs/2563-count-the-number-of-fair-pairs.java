class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {

        int n=nums.length;
        long count=0;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){

            int val=nums[i];

            int lb=low(val,i+1,n,lower,nums);
            int ub=up(val,i+1,n,upper,nums);
        
            count+=(ub-lb);


        }
        return count;
        
    }

    public int low(int v,int l, int r, int t, int [] n){
        
        
        while(l<r){
            int mid=(l+r)/2;
            if(n[mid]+v >=t){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    public int up(int v,int l, int r, int t, int[]n ){

         
        while(l<r){
            int mid=(l+r)/2;
            if(n[mid]+v >t){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;

    }
}