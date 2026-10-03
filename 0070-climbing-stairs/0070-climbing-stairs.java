class Solution {

    public int climbStairs(int n) {

        // ============================================================
        // 1. TOP-DOWN DP / MEMOIZATION
        //    State = current position "i"
        //    Time  : O(n)
        //    Space : O(n)
        // ============================================================
        return topDownMemoization(n, 0, new int[n + 1]);


        // ============================================================
        // 2. BOTTOM-UP DP / TABULATION
        //    Time  : O(n)
        //    Space : O(n)
        // ============================================================
        /*
        return bottomUpTabulation(n);
        */


        // ============================================================
        // 3. TOP-DOWN DP / MEMOIZATION
        //    Fibonacci style, State = n
        //    Time  : O(n)
        //    Space : O(n)
        // ============================================================
        /*
        return topDownFibonacci(n, new int[n + 1]);
        */


        // ============================================================
        // 4. PLAIN RECURSION
        //    State = current position "i"
        //    Time  : O(2^n)
        //    Space : O(n)
        // ============================================================
        /*
        return plainRecursion(n, 0);
        */


        // ============================================================
        // 5. PLAIN RECURSION / FIBONACCI STYLE
        //    Time  : O(2^n)
        //    Space : O(n)
        // ============================================================
        /*
        return plainFibonacci(n);
        */
    }


    // ================================================================
    // 1. TOP-DOWN DP / MEMOIZATION
    // ================================================================
    public int topDownMemoization(int n, int i, int[] dp) {

        // Reached exactly n
        if (i == n)
            return 1;

        // Crossed n
        if (i > n)
            return 0;

        // Already calculated
        if (dp[i] != 0)
            return dp[i];

        // Take 1 step + Take 2 steps
        return dp[i] =
                topDownMemoization(n, i + 1, dp)
              + topDownMemoization(n, i + 2, dp);
    }


    // ================================================================
    // 2. BOTTOM-UP DP / TABULATION
    // ================================================================
    public int bottomUpTabulation(int n) {

        if (n <= 1)
            return 1;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    // ================================================================
    // 3. TOP-DOWN DP / MEMOIZATION - FIBONACCI STYLE
    // ================================================================
    public int topDownFibonacci(int n, int[] dp) {

        if (n <= 1)
            return dp[n] = 1;

        if (dp[n] != 0)
            return dp[n];

        return dp[n] =
                topDownFibonacci(n - 1, dp)
              + topDownFibonacci(n - 2, dp);
    }


    // ================================================================
    // 4. PLAIN RECURSION
    // ================================================================
    public int plainRecursion(int n, int i) {

        if (i == n)
            return 1;

        if (i > n)
            return 0;

        return plainRecursion(n, i + 1)
             + plainRecursion(n, i + 2);
    }


    // ================================================================
    // 5. PLAIN RECURSION / FIBONACCI STYLE
    // ================================================================
    public int plainFibonacci(int n) {

        if (n <= 2)
            return n;

        return plainFibonacci(n - 1)
             + plainFibonacci(n - 2);
    }
}