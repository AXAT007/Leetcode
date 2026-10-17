class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return nextLargerElement(nums1,nums2);
    }
    public int[] nextLargerElement(int[] arr1,int[] arr) {
        
        int[] ans = new int[arr1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> st = new ArrayDeque<>();

        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                map.put(arr[st.pop()], arr[i]);
            }
            st.push(i);
        }
        for(int i=0;i<arr1.length;i++){
            ans[i]=map.getOrDefault(arr1[i],-1);
        }
        return ans;
    }
}