class Solution {
    public long sumAndMultiply(int n) {
        int sum=0;
        long result=0;

        while (n > 0) {
        int digit = n % 10;
        sum=sum+digit;
        if (digit != 0) {
            result = result * 10 + digit;
        }
        n /= 10;
    }

    
    long finalNum = 0;
    while (result > 0) {
        finalNum = finalNum * 10 + (result % 10);
        result /= 10;
    }

    return finalNum *sum;
        
        
    }
}