class Solution {
    public int maxSubarrayLength(int[] nums, int k) {


        int n=nums.length;
        Map<Integer,Integer> fre= new HashMap<>();

        int i=0;
        int j=0;
        int maxLen=0;
        while(j<n){

            if(!fre.containsKey(nums[j]) || fre.get(nums[j])<=k  ){
                fre.put(nums[j],fre.getOrDefault(nums[j],0)+1);
            }

            while(fre.get(nums[j])>k){
                fre.put(nums[i],fre.get(nums[i])-1);
                if(fre.get(nums[i])==0){
                    fre.remove(nums[i]);
                }
                i++;
            }
            maxLen=Math.max(maxLen,(j-i+1));
            j++;
        }
        return maxLen;
        
    }
}