class Solution {
    public int[] dailyTemperatures(int[] t) {

        int n=t.length;

        int a[]= new int[n];

        Stack<Integer> st= new Stack<>();

        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty()&& t[st.peek()]<=t[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                int l=st.peek()-i;
                a[i]=l;
            }else{
                //System.out.println(a[i]);
                a[i]=0;
            }
            st.add(i);
        }
        return a;
        
    }
}