class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        // from left to right
        
        int pre= nums[0];
        int n=nums.length;
        int j=0;
        int max=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){

            if(nums[i]>pre){
                pre=nums[i];
               
                max=Math.max(max,i-j+1);
                
            }else{
                
                j=i;
                pre=nums[i];

            }

        }

        j=0;
        pre=nums[0];


        for(int i=1;i<n;i++){

            if(nums[i]<pre){
                pre=nums[i];
               max=Math.max(max,i-j+1);
            }else{
               
                j=i;
                pre=nums[i];

            }

        }

        return max==Integer.MIN_VALUE?1:max;

        
        
    }
}