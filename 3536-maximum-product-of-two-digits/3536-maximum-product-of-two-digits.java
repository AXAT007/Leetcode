class Solution {
    public int maxProduct(int n) {
        int ans=1;
        int first=0;
        int sec=0;
        // while(n>0){
        //     if(first==0){

        //     }
        // }

        int size=0;
        int temp=n;
        for(;temp>0;temp=temp/10){
            size++;
            
        }
        int []  arr=new int [size];
        temp=n;
        for(int i=0;i<size;i++){
            arr[i]=temp%10;
            temp/=10;
        }

        for(int val:arr){
            first=Math.max(first,val);
        }
        for(int i=0;i<size;i++){
            if(arr[i]==first){
                arr[i]=-1;
                break;
            }
        }
        for(int val:arr){
            sec=Math.max(sec,val);
        }
        return first*sec;
    }
}