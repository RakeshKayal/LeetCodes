class Solution {

    int[] arr;
    int[] lis;  
    int[] lds;  

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        arr = nums;

        lis = new int[n];
        lds = new int[n];
        Arrays.fill(lis, -1);
        Arrays.fill(lds, -1);

        int maxMountain = 0;

        for (int i = 0; i < n; i++) {
            int inc = g(i);   
            int dec = h(i);   

            if (inc > 1 && dec > 1) {          
                maxMountain = Math.max(maxMountain, inc + dec - 1);
            }
        }

        return n - maxMountain;
    }

   
    public int g(int i) {
        if (lis[i] != -1) return lis[i];

        int best = 1;
        for (int j = 0; j < i; j++) {
            if (arr[j] < arr[i]) {
                best = Math.max(best, 1 + g(j));
            }
        }
        return lis[i] = best;
    }

    
    public int h(int i) {
        if (lds[i] != -1) return lds[i];

        int best = 1;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[i]) {
                best = Math.max(best, 1 + h(j));
            }
        }
        return lds[i] = best;
    }
}