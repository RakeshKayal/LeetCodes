class Solution {
    public int maxLength(int[] nums) {

        int n= nums.length;
        int max=0;

        for (int i=0;i<n;i++){
            long p= 1;


            long lcm1= nums[i];
            long gcd1=nums[i];
            for(int j=i;j<n;j++){
                p*=nums[j];
                lcm1=lcm(lcm1,nums[j]);
                gcd1=gcd(gcd1,nums[j]);

                if(p==(lcm1*gcd1)){
                    max=Math.max(max,j-i+1);
                }
            }
        }

        return max;
        
    }
    public long gcd(long a, long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;
            
        }
        return a;

    }
    public long lcm(long a, long b){
       
       if(a==0 || b==0) return 0;

       return (a/gcd(a,b))*b;
    }
}