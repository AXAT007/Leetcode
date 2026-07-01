class Solution {
    public int[] sortArray(int[] nums) {
        merge_Sort(nums,0,nums.length-1);
        return nums;
    }
        static void merge_Sort(int [] arr,int start,int end)
    {
        if(start>=end) return;

        int mid=(start+end)/2 ;
        merge_Sort(arr,start,mid);
        merge_Sort(arr,mid+1,end);
        merge(arr,start,mid+1,end);
    }

   static void merge(int [] arr,int start,int mid,int end){
        int [] temp=new int[end-start+1];
        int k=0;

        int i=start , j=mid;
        while(i<mid&&j<=end){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(i<mid){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }
        k=0;
        for( i=start;i<=end;i++){
            arr[i]=temp[k++];
        }
}
}