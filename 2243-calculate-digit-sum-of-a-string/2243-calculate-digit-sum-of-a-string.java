class Solution {
    public String digitSum(String s, int k) {

       

    String sa=s;

    while(sa.length()>k){

        int sum=0;
        int c=0;
        StringBuilder sb= new StringBuilder();

        for(int i=0;i<sa.length();i++){

            sum+=(int) sa.charAt(i)-'0';
            c++;
            if(c==k || i==sa.length()-1){
                sb.append(sum);
                c=0;
                sum=0;
            }
            
        }
        sa=sb.toString();

    }
    return sa;
        
    }
}