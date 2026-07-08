class Solution {
    static int MOD=(int)1e9+7;
    public int[] sumAndMultiply(String s, int[][] queries) {

        // int n=s.length();

        // String [] ans= new String[n];
        // String s2="";

        // for(int i=0;i<n;i++){
           
        //     s2+=(s.charAt(i)-'0'!=0) ? s.charAt(i):"";
        //    ans[i]=s2;

            
        // }

        


        // int l=3;
        // int r=5;

        // String s2=ans[r];
        // int a=ans[l-1].length();
        // System.out.println(s2.substring(a));

//         int p[]= new int[n];
//         p[0]=s.charAt(0)-'0';
//         for(int i=1;i<n;i++){
//             p[i]=p[i-1]+s.charAt(i)-'0';
//         }


//         int k=0;
//         int res[]= new int[queries.length];


        
// for (int[] it : queries) {
//     int l = it[0];
//     int r = it[1];
//     String s1 = ans[r];

//     if (l - 1 < 0) {
//         long a = 0;
//         if (s1 != null && !s1.isEmpty()) {
            
//             for (int i = 0; i < s1.length(); i++) {
//                 a = (a * 10 + (s1.charAt(i) - '0')) % MOD;
//             }
//         }
        
//         long sum = (p[r] % MOD + MOD) % MOD; 
//         int an = (int) ((a * sum) % MOD);
//         res[k++] = an;
//     } 
//     else {
//         int le = ans[l - 1].length();
        
       
//         String as = (s1.length() > le) ? s1.substring(le) : ""; 

//         long b = 0;
//         if (!as.isEmpty()) {
           
//             for (int i = 0; i < as.length(); i++) {
//                 b = (b * 10 + (as.charAt(i) - '0')) % MOD;
//             }
//         }

//         long su = (p[r] - p[l - 1] + MOD) % MOD;
//         int an1 = (int) ((b * su) % MOD);
//         res[k++] = an1;
//     }
// }

//         return res;


    int n=s.length();
    int p[]= new int [n];

    p[0]=s.charAt(0)-'0';

    for(int i=1;i<n;i++){
        p[i]=p[i-1]+s.charAt(i)-'0';
    }

    int nz[]= new int [n];

    nz[0]=s.charAt(0)-'0'==1 ?1 :0;
    for(int i=1;i<n;i++){
        int dig=s.charAt(i)-'0';

        if(dig!=0){
            nz[i]=nz[i-1]+1;
        }else{
            nz[i]=nz[i-1];
        }
    }

    long digit[] = new long[n];   // safer to make this long[] outright

digit[0] = s.charAt(0)-'0';
for(int i=1;i<n;i++){
    int d = s.charAt(i)-'0';
    if(d != 0){
        digit[i] = (((long) digit[i-1] * 10) % MOD + d) % MOD;
    } else {
        digit[i] = digit[i-1];
    }
}


    long pow10[]=new long[n+1];

    pow10[0]=1;
    for(int i=1;i<n+1;i++){
        pow10[i]=(pow10[i-1]*10)%MOD;
    }


    int res[]=new int[queries.length];
    int j=0;


    for(int it[] :queries){
        int l=it[0];
        int r=it[1];

        long sum=p[r]-((l==0)?0:p[l-1]);

        int k=nz[r]-((l==0)?0:nz[l-1]);
        
        long x=digit[r]-(((l)==0? 0 : digit[l-1]*pow10[k] %MOD)+MOD)%MOD;

       long asn = (x % MOD) * (sum % MOD) % MOD;
        asn = (asn + MOD) % MOD;
        res[j++] = (int) asn;


    }

    return res;







        
    }
}