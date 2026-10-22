class Solution {

    int tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public int longestPalindrome(String s) {

        // return tabulation(s, new StringBuilder(s).reverse().toString());
        //  /*
        int[] arr = new int[26 * 2];
        // System.out.print('z'>'Z');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'a') {
                arr[c - 'A']++;
            } else {
                arr[26 + (c - 'a')]++;
            }

        }
        int maxodd = 0;
        int idx = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (x % 2 == 1) {
                 if (maxodd < x) {
                    idx = i;
                    maxodd=x;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (x % 2 == 0) {
                ans += x;
            } else {
                if (i != idx) {
                    ans += x - 1;
                } else {
                    ans += arr[i];
                }
            }
        }
        return ans;
        // */
    }
}