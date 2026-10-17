class Solution {
    public int minSwaps(int[] nums) {



        List<int[]> l= new ArrayList<>();  // digit sum, num

        for(int i=0;i<nums.length;i++){
           
           int dig_sum=findSum(nums[i]);
           l.add(new int[]{dig_sum,nums[i],i});

        }


        l.sort((a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int n=nums.length;

       boolean[] visited = new boolean[n];
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
           
            int originalIdx = l.get(i)[2];

            
            if (visited[i] || originalIdx == i) {
                continue;
            }

          
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
              
                j = l.get(j)[2];
                cycleSize++;
            }

           
            if (cycleSize > 0) {
                totalSwaps += (cycleSize - 1);
            }
        }

        return totalSwaps;
        
    }

    public int findSum(int s){

        int sum=0;
        while(s!=0){
            int res=s%10;
            sum+=res;
            s/=10;
        }

        return sum;
    }
}