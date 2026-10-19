class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int ans = 0;
        int curr = 0;

        int n = heights.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller, -1);
        Arrays.fill(prevSmaller, -1);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                nextSmaller[st.pop()] = i - 1;
            }
            st.push(i);
        }
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                prevSmaller[i] = st.peek() + 1;
            }
            st.push(i);
        }

        // mien 

        // for (int i = 0; i < n; i++) {
        //     int width=1;
        //     int a = nextSmaller[i];
        //     int b = prevSmaller[i];

        //     if (a !=-1) {
        //         width += a-i;
        //     }
        //     else{
        //         width+=n-i-1;
        //     }

        //     if (b !=-1) {
        //         width +=i- b;
        //     }
        //     else{
        //         width+=i;
        //     }

        //     ans = Math.max(ans, heights[i] * width);
        // } 

                for (int i = 0; i < n; i++) {
            int a = nextSmaller[i];
            int b = prevSmaller[i];

            if (a ==-1) {
                 a=n-1;
            }

            if (b ==-1) {
                b=0;
            }

            ans = Math.max(ans, heights[i] *(a-b+1) );
        } 

        return ans;
    }
}

/*


        int n = heights.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller, -1);
        Arrays.fill(prevSmaller, -1);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                // nextSmaller[st.pop()] = heights[i];
                nextSmaller[st.pop()] = i-1;
            }
            st.push(i);
        }
        // while(!st.isEmpty()){
        //     int i=st.pop();
        //     if(nextSmaller[i]==-1)
        //     nextSmaller[i] = heights[i];
        //     // nextSmaller[i] = n-i-1;
        // }
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop() ;
            }
            if(!st.isEmpty() && heights[st.peek()] < heights[i]){
                // prevSmaller[i] = heights[st.peek()];
                prevSmaller[i] = st.peek()+1;
            }
            st.push(i);
        }
        // while(!st.isEmpty()){
        //     int i=st.pop();
            // if(prevSmaller[i]==-1)
            // prevSmaller[i] =i;
        //     prevSmaller[i] = heights[i];
        // }/
        // prevSmaller[0]=0;
        System.out.println(Arrays.toString(prevSmaller));
        System.out.println(Arrays.toString(nextSmaller));
        return -1;

*/
