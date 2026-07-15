class Solution {
    public int gcdOfOddEvenSums(int n) {

        return n;


        // int s=0;
        // int s1=0;
        // for(int i=1;i<=(2*n);i++){

        //     if((i&1)==0){
        //         s++;
        //     }else{
        //         s1++;
        //     }

        // }
        // return gcd(s,s1);
        
    }

    public int gcd(int a, int b){

        if(a==0){
            return b;
        }

        return gcd(b%a,a);
    }
}