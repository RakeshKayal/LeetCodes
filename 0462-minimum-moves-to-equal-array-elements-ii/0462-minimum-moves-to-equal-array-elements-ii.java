class Solution {
    public int minMoves2(int[] nums) {

        if(nums.length==1) return 0;
        Arrays.sort(nums);

        int m=nums[nums.length/2];
        
        int c=0;

        for(int it: nums){
            c+=Math.abs(it-m);
        }
        return c;
    }
}