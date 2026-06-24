class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        Arrays.sort(nums);
        subset(nums,result,curr,0);
        return result;        
    }
    public static void subset(int[] arr,List<List<Integer>> result,List<Integer> curr,int i) {
        if (i == arr.length) {
            if(!result.contains(curr)) {
                result.add(new ArrayList<>(curr));
            }
            return;
         }

        curr.add(arr[i]);
        subset(arr, result, curr, i + 1);
        curr.removeLast();
        subset(arr, result, curr, i + 1);
    }
}