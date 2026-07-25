class Solution {
    public int maxProduct(int n) {
        int first=0;
        int sec=0;

         int val=0;
        while(n>0){
            val=n%10;
            if(val>first){
                int t=first;
                first=val;
                sec=Math.max(sec,t);
            }
            else{
                sec=Math.max(sec,val);
            }
            n/=10;
        }
       
        return first*sec;
    }
}