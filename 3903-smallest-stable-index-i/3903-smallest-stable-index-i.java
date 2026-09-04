class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n= nums.length;
        int []p= new int [n];

        p[0]= nums[0];

        for( int i=1;i<n;i++){
            p[i]=Math.max(p[i-1],nums[i]);
        }
        
        int [] s= new int[nums.length];

        s[nums.length-1]= nums[nums.length-1];
        int max=nums[nums.length-1];

        for( int i =nums.length-2;i>=0;i--){

            s[i]=Math.min(s[i+1],nums[i]);
            max=Math.max(max,nums[i]);
        }


        for( int i=0;i<nums.length;i++){

            

            if(p[i]-s[i]<=k){
                return i;
            }
        }
        return -1;
        
    }
}