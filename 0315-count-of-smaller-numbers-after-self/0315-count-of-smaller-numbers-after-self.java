class Solution {
    class Pair {
        int val;
        int idx;

        Pair() {
        }

        Pair(int x, int y) {
            val = x;
            idx = y;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {

            arr[i] = new Pair();
            arr[i].val = nums[i];
            arr[i].idx = i;
            ans.add(0);
        }
        mergeSort(arr, ans, 0, nums.length - 1);
        return ans;
    }

    void mergeSort(Pair[] arr, List<Integer> ans, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, ans, start, mid);
            mergeSort(arr, ans, mid + 1, end);
            merge(arr, ans, start, mid, end);
        }
    }

    void merge(Pair[] arr, List<Integer> ans, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int rightCount = 0;
        Pair[] temp = new Pair[end - start + 1];

        while (i <= mid && j <= end) {
            if (arr[i].val <= arr[j].val) {
                ans.set(arr[i].idx, ans.get(arr[i].idx) + rightCount);
                temp[k++] = arr[i++];
            } else {
                // int count=end-j+1;
                // int count=0;
                // for(int s=mid+1;s<=end;s++){
                //     if(arr[s].val<arr[i].val){
                //         count++;
                //     }
                //     else{
                //         break;
                //     }
                // }
                // ans.set(arr[i].idx,ans.get(arr[i].idx)+count);
                temp[k++] = arr[j++];
                rightCount++;
            }
        }
        while (i <= mid) {
            ans.set(arr[i].idx, ans.get(arr[i].idx) + rightCount);

            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }
        k = 0;
        for (int x = start; x <= end; x++) {
            arr[x] = temp[k++];
        }
    }
}