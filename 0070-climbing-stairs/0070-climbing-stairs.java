class Solution {
    public int climbStairs(int n) {
        int [] arr=new int [46];
        arr[0]=1;
        arr[1]=1;
        return climbstairs(n,arr);
    }
    public int climbstairs(int n,int [] arr) {
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
       return arr[n];
    }
}