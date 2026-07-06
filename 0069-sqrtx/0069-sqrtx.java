class Solution {
    public int mySqrt(int x) {
        if(x==0||x==1) return x;
     return fxn(x,0,x);   
    }
    int fxn(int x,int s, int e){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid==x/mid){
                return mid;
            }
            else if(mid>x/mid){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return e;
    }
}