class Solution {
    public long maxAlternatingSum(int[] nums) {
        

        int n= nums.length;
        long [] s= new long[n];
        int i=0;

        for(int it: nums){
            s[i++]=it*it;
        }


        Arrays.sort(s);

        int ne= s.length/2;
        long max=0;
        int c=0;
        for(int j=0;j<s.length;j++){
            if(c!=ne){
                max-=s[j];
                c++;
            }else{
                max+=s[j];
            }
        }

        return max;



        

        
    }
}