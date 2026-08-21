class Solution {
    public int maxArea(int[] height) {

       /* so what will be my intution  to slove this 
        like it said to find the maximum water i can store
        .......

         to do this i need  to bar so that i can store water inside it
         to miximize it  i need one bar which is as close to second bar right
         means suppose i select a bar now i want to select another bar which
         is as closo or greater then the 1st bar so that  the  area of
         store water will maximum

         - Every time we move inward, width decreases by 1.
     - If we move the TALLER bar:
       * The height is still limited by the existing shorter bar (or worse).
       * Less width * same/smaller height = GUARANTEED smaller area. No point!
     - If we move the SHORTER bar:
       * We discard the current bottleneck in hope of finding a taller bar that can compensate for the lost width.

         1,8,6,2,5,4,8,3,7   i select a ber 1 and i have only 2 option
         selet greater or equal bar  so 8, 6, 2.... 7 all are greater
         but now i need max dist among them which is 7  now i want to be maximuze the 7 by selete 8 .... 
         
         */




      int n= height.length;
        int i=0;
        int j=n-1;

        int max=-1;


        while(i<j){    // calculate area  = >  minHeight * dist
            max=Math.max(max,(Math.min(height[i],height[j])*(j-i)));
            if(height[i]<height[j]){
                i++;
            }else if(height[j]<height[i]){
                j--;
            }else{
                i++;
                j--;
            }
        }
        return max;  // O(n) tc , O(1) sp

      
        



        
    }
}