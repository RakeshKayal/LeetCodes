class Solution {
    public int trap(int[] height) {




        /* 
    The intuition behind this :- 

    Let's forget about the problem for a moment and just visualize a rainy night. 
    In the morning, when you wake up, what do you see? 

    You might see something like water accumulating between two large houses. 
    The left house is slightly smaller than the right, so the water will accumulate 
    only to the height of the left house and not any higher. If it exceeds that height, 
    the water will overflow. 

    That’s the concept I’m using here. 
*/ 


        int n=height.length;
        
        int left[]= new int[n];

        int max=height[0];
        left[0]=max;
        for(int i=1;i<n;i++){
            if(max<height[i]){
                max=height[i];
            }
            left[i]=max;       
        }
      
        int right[]= new int[n];
        max=height[n-1];
        right[n-1]= height[n-1];
        for(int i=n-2;i>=0;i--){

            if(max<height[i]){
                max=height[i];
            }
            right[i]=max;   

        }


        int c=0;
        for(int i=0;i<n;i++){

            c+=Math.min(left[i],right[i])-height[i];
        }
        return c; 

        // Tc- > O(n) sp ->O(n)

        /* you can do  in two pass 
        first by storing right max 
        and then travers from left to right and use a 
        running max */

        // also you can do it by one pass More Optimize  


      
    }
}