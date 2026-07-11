class Solution {
    public long countSubarrays(int[] nums, long k) {


        long sum=0;
        int i=0;
        int j=0;
        long count=0;
        while(j<nums.length){

            sum+=nums[j];

            long p=sum*(j-i+1);

            while(p>=k){
                sum-=nums[i];
                i++; 
                long a= (j-i+1)*sum;
                p=a;
            }
            count+=(j-i+1);
            j++;
        }

        return count;
        
    }
}