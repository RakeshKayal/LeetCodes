class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int n= nums.length;
        Map<Integer,Integer> fre= new HashMap<>();
        fre.put(0,1);
        int sum=0;
        int c=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int need=sum-goal;
            if(fre.containsKey(need)){
                c+=fre.get(need);
            }
            fre.put(sum,fre.getOrDefault(sum,0)+1);
        }
        return c;
        
    }
}