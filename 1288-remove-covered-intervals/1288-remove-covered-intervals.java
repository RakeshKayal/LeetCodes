class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(a[0], b[0]);
        });

        
        // for( int i=0;i<intervals.length;i++){
        //     for(int j=0;j<intervals[i].length;j++){
        //         System.out.print(intervals[i][j]+" ");
        //     }
        //     System.out.println();
        // }


       int n=intervals.length;
       int remove=0;

        int a=intervals[0][0];
        int b=intervals[0][1];


        for( int i=1;i<n;i++){

            int c=intervals[i][0];
            int d=intervals[i][1];

            if(a<=c && b>=d){
                remove++;
            }else{
                a=c;
                b=d;
            }
        }

        return n-remove;


        
    }
}