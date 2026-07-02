class Solution {
    public int minOperations(int[] nums) {

        Map<Integer,Integer> m= new HashMap<>();

        for( int i=0;i<nums.length;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }

        
        int c=0;

        for( int i=0;i<nums.length;i++){
            

            int n=nums[i];
             if(!m.containsKey(n)) continue;
            if(m.get(n)==1){
                return -1;
            }
            int a= m.get(nums[i]);
            
            int k=fun1(0,a);
            System.out.println(k);
            c+=k;
            m.remove(n);
           
        }
        return c;

        
    }

    public int fun(int sum, int t){

        if(sum==t){
            return 0;
        }

        if(sum>t){
            return Integer.MAX_VALUE;
        }    

        int r1 = fun(sum + 2, t);
        int t1 = (r1 == Integer.MAX_VALUE) ? Integer.MAX_VALUE : 1 + r1;

        int r2 = fun(sum + 3, t);
        int t2 = (r2 == Integer.MAX_VALUE) ? Integer.MAX_VALUE : 1 + r2;


       
        return Math.min(t1,t2);
    }
    public int fun1(int sum, int t) {
    int diff = t - sum;
    if (diff == 1) return -1; 
    return (diff + 2) / 3; 
}
}