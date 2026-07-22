class Solution {
    public int maxScore(int[] c, int k) {

        int total=0;

        for(int it : c){
            total+=it;
        }
        //  System.out.println(total);

        int size=c.length-k;

        int i=0;
        int j=0;
        int sum=0;
        int max=0;
        while(j<c.length){

            sum+=c[j];


             while(j-i+1>size){

                sum-=c[i];
                i++;
            }

            if(j-i+1==size){
                int m=total-sum;
                // System.out.println(sum+": "+m);
                max=Math.max(max,m);
            }
           
            j++;

        }

        return max;


        
    }

   
}