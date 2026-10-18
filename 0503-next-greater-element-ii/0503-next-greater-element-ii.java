class Solution {
    public int[] nextGreaterElements(int[] arr) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {

                ans[st.pop()] = arr[i];

            }
            st.push(i);
        }

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                int j = st.pop();
                if (ans[j] == -1) {
                    ans[j] = arr[i];
                }
            }
            st.push(i);
        }
        return ans;
    }

    int[] fxn2(int[] nums) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < 2 * n; i++) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {

                ans[st.pop()] = arr[i];

            }
            if (i < n)
                st.push(i);
        }
        return ans;
    }

    // wrong ans
    public int[] fxn1(int[] nums) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            if (ans[n - 1] == -1 && nums[n - 1] < nums[i]) {
                ans[n - 1] = nums[i];
            }

            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                ans[st.pop()] = nums[i];
            }
            st.push(i);
        }
        return ans;
    }
}