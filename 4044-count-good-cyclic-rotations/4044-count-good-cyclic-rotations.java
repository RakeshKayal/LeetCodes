class Solution {
    public int countGoodRotations(int[] nums) {

        int n= nums.length;
        long p[]=new long[n];

        p[0]=nums[0];

        for(int i=1;i<n;i++){
            p[i]=p[i-1]+nums[i];
        }

        long sum=p[n-1];


    int w=n/2;
    int i=0;
    int j=0;
    int c=0;
    while(j<n-1){
        
        if(j-i+1==w){
            long mid1=p[j]- ((i==0)?0: p[i-1]);
            long last1=sum-mid1;
            if(mid1>last1){
                c++;
            }
            long mid=last1;
            long last=sum-mid;
            if(mid>last){
                c++;
            }
            i++;
        }
        j++;
    }

    return c;
        
    }
}