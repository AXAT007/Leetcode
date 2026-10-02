class Solution {
    public int totalNumbers(int[] digits) {
        int count=0;
        int [] arr=new int[10];
        for(int x:digits){
            arr[x]++;
        }
        for(int i=100;i<999;i=i+2){
            int x=i;
            int first=x%10;
            x/=10;
            int sec=x%10;
            x/=10;
            int third=x%10;
            arr[first]--;
            arr[sec]--;
            arr[third]--;
            if(arr[first]>=0 && arr[sec]>=0 && arr[third]>=0){
                count++;
            }
            arr[first]++;
            arr[sec]++;
            arr[third]++;
            
        }
        return count;
    }

// int [] ans{0};
    // public int totalNumbers(int[] digits) {
    //  int zero=0;
    //  int even=0;
    //  int total=digits.length;
    //  for(int x:digits){
    //     if(zero==x){
    //         zero++;
    //     }
    //     if(x%2==0) even++;
    //  }   
    //  int ans1=0;
    //  int ans2=0;
    //  if(zero>0){
    //     if(zero==1){
    //         // return 
    //     }
    //  }
    //  return (total-zero-1) *( total-2)* (even);
    // }
    // int rec(digits,set,i,num){
    //     if(num>99){
    //         if(set.add(num)){
    //             ans[0]++;
    //         }
    //         return;
    //     }
    //     for(int i=0;i<digits.length;i++){
    //         int x=digits[i];
    //         while(x%2==1 && num>9){
    //             i++;
    //         }
    //         num=num*10+x;
    //     }
    // }
}