class Solution {
    public long repairCars(int[] ranks, int cars) {

        long time[]= new long [(int) 1e6+1];

        for(int i=0;i<time.length;i++){
            time[i]= (long)i*i;
            //System.out.println(time[i]);
        }

        Arrays.sort(ranks);
        long max=ranks[ranks.length-1];
        long l=1;
        long r=max*time[cars]; 

        long ans=0;


        while(l<=r){

            long mid=(l+r)/2;
            if(isFeasible(mid,time, ranks,cars)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }

        }
        return ans;
        
    }

    public boolean isFeasible(long minT, long[] time, int [] r, int c){

        int h=0;

        for(int i=0;i<r.length;i++){

            long a= r[i];
            long lb=LowerBound(minT,time,a);
            //System.out.println(a+" : "+lb);
            h+=lb;

            if(h>=c) return true;
        }
        return h>=c;
    }

    public long LowerBound(long t, long time[], long a){

        long l=0;
        long h=time.length-1;
        long ans=0;

        while(l<=h){

            long mid=(l+h)/2;

            if(time[(int)mid]*a <=t){
                ans=mid;
                //System.out.println(mid+" : "+time[(int)mid]);
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
}