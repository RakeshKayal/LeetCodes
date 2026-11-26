class Solution {
    public boolean canAliceWin(int n) {
int s=10;
boolean isAlice=false;
while(n>=s){
    n-=s;
    s--;
    isAlice=!isAlice;

}
return isAlice;
        
    }
}