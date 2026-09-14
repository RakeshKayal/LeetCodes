class Solution {
    public int uniqueXorTriplets(int[] nums) {

        if(nums.length<3) return nums.length;

        int num=0;
        for(int it : nums){
            num=Math.max(it,num);
        }
        int bits = Integer.SIZE - Integer.numberOfLeadingZeros(num);

        return (int)Math.pow(2,bits);

    }
}