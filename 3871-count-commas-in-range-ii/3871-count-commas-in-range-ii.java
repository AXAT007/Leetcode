class Solution {
    public long countCommas(long n) {
// for 1st approach refer its 1st part

        // int comma=0;
        long count=0;
        long val=1000;
        while(val<=n){
                
            count+=n-val+1;
            val*=1000;
        }
        return count;
    }
}