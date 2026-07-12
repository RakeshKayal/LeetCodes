class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int a[]= Arrays.copyOf(arr, arr.length);

        Arrays.sort(a);

        Map<Integer,Integer> m= new HashMap<>();

        int k=1;
        for(int j=0;j<a.length;j++){

            if(j>0 &&a[j]==a[j-1]){
                
                continue;
            }

            m.put(a[j],k);
            k++;
        }

        System.out.println(m);

        int ans[]=new int [arr.length];

        for(int i=0;i<arr.length;i++){
            ans[i]=m.get(arr[i]);
        }
        return ans;


        
    }
}