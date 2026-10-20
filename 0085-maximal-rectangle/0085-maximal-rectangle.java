class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] mat = new int[matrix[0].length];
        for (int i = 0; i < mat.length; i++) {
            if (matrix[0][i] == '0') {
                mat[i] = 0;
            } else
                mat[i] = 1;
        }

        int ans = getArea(mat);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0'){
                    mat[j]=0;
                }
                else  {
                    mat[j] +=  1;
                }
            }
            ans = Math.max(ans, getArea(mat));
        }
        return ans;
    }

    int getArea(int[] heights) {
        int n = heights.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, n);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                prevSmaller[i] = st.peek();
            }
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int rightBoundary = nextSmaller[i];
            int leftBoundary = prevSmaller[i];
            ans = Math.max(ans, heights[i] * (rightBoundary - leftBoundary - 1));
        }
        return ans;
    }
}