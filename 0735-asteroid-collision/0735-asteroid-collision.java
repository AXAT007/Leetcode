class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]<0){
                left(asteroids,i);
            }
            else if(asteroids[i]>0){
                right(asteroids,i);
            }
        }
        int count=0;
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]!=0){
                count++;
            }
        }
        int j=0;
        int [] ans=new int[count];
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]!=0){
                ans[j]=asteroids[i];
                j++;
            }
        }
        return ans;
    }
    void left(int [] arr,int i){
        int b=Math.abs(arr[i]);
        for(int j=i-1;j>=0;j--){
            int a=arr[j];
            if(a<0){
                return;
            }
            else if(a>0){
                if(a>b){
                    arr[i]=0;
                    return;
                }
                else if(a<b){
                    arr[j]=0;
                }
                else if(a==b){
                    arr[i]=0;
                    arr[j]=0;
                    return;
                }
            }
        }
    }
      void right(int [] arr,int i){
        
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]>0){
                return;
            }
            else if(arr[j]<0){
                if(Math.abs(arr[j])>arr[i]){
                    arr[i]=0;
                    return;
                }
                else if(Math.abs(arr[j])<arr[i]){
                    arr[j]=0;
                }
                
                else{
                   arr[i]=0;
                    arr[j]=0;
                   return;
                }
            }
        }
    }
}