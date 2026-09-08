class Solution {
    public int countCommas(int n) {
        int comma=0;
        int count=0;
        int val=1000;
        while(val<=n){
            if(val*1000<n){
                
                comma++;
                count+=n-val*comma;
                val*=1000;
            }
            else{
                return count+n-val+1;
            
            }
        }
        return count;
    }
}