class Solution {
    public int[] twoSum(int[] nums, int target) {


        List<int[]> l= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            l.add(new int[]{nums[i],i});
        }
        l.sort((a,b)->Integer.compare(a[0],b[0]));
        int i=0;
        int j=l.size()-1;

        while(i<j){

            int sum= l.get(i)[0]+l.get(j)[0];
            if(sum > target){
                j--;
            }else if(sum < target){
                i++;

            }
            else{
                return new int[]{l.get(i)[1],l.get(j)[1]};
            }
        }
        return new int[]{-1,-1};
        
    }
}