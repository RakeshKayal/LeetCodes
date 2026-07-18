class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        return f(nums[0],nums[nums.length-1]);
    }
    public int f(int a, int b){
        if(a==0) return b;
        return f(b%a,a);
    }
}