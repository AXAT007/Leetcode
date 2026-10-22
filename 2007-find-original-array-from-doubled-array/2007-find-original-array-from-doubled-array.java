class Solution {
    public int[] findOriginalArray(int[] arr) {
        // HashSet<Integer> s=new HashSet<>();
        // for(int x:changed){
        //     s.add()
        // }
        int n=arr.length;
Arrays.sort(arr);
        if(n%2==1) return new int[0];
        int[] ans=new int[n/2];
        int k=0;
        int odd=0;
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(arr[i]!=-1){
            // if(arr[i]%2==1){
            //     odd++;
            // }
            // else{
                flag=false;
                int half=arr[i]*2;
                for(int j=i+1;j<n;j++){
                    if(arr[j]==half){
                        ans[k++]=arr[i];
                        arr[j]=-1;
                        arr[i]=-1;
                        flag=true;
                        break;
                    }
                }
                if(!flag) return new int[0];
            }
            // if(odd>n/2) return new int[0];
        // }
        }
        return ans;

    }
}