class Solution {

    static String s = "";
   public int lcs(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];

        int ans=tabulation(s1,s2,dp,n,m);
        int size=ans;
        
        int i=n,j=m;
        char[] arr=new char[size];
        while (i > 0 && j > 0 && size > 0){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    arr[size-1]=s1.charAt(i-1);
                    i--;
                    j--;
                    size--;
                }
                else{
                    if(dp[i-1][j]>dp[i][j-1]){
                        i--;
                    }
                    else{
                        j--;
                    }
                }
        }
        String ss=new String(arr);
        System.out.println(ss);
        return ans;
    }
    
    int tabulation(String s1, String s2,int[][] dp,int n,int m){
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // int[][] dp = new int[text1.length()][text2.length()];
        // for (int[] x : dp) {
        //     Arrays.fill(x, -1);
        // }

        return lcs(text1,text2);
        // s=new String();
        // int size=memoiz2(text1,text2,text1.length()-1,text2.length()-1,dp);
        // System.out.print("LCS of " + text1 + " and " + text2 + " is ");
        // System.out.print(s);
        
// return size;
        // return memoiz(text1,text2,text1.length()-1,text2.length()-1,dp);
        // return rec(text1,text2,text1.length()-1,text2.length()-1);

        // return tabulation(text1,text2);
        // return no_Space(text1, text2);
        // return lcs(text1, text2, text1.length(), text2.length());
    }

    public int memoiz2(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            s=s+s1.charAt(i);
            return dp[i][j] = 1 + memoiz(s1, s2, i - 1, j - 1, dp);
        }
        int left = memoiz(s1, s2, i - 1, j, dp);
        int right = memoiz(s1, s2, i, j - 1, dp);

        return dp[i][j] = Math.max(left, right);
    }

    static int lcs(String X, String Y, int m, int n) {
        StringBuilder[][] dp = new StringBuilder[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = new StringBuilder();
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = new StringBuilder(dp[i - 1][j - 1])
                            .append(X.charAt(i - 1));
                } else {
                    dp[i][j] = dp[i - 1][j].length() >= dp[i][j - 1].length()
                            ? new StringBuilder(dp[i - 1][j])
                            : new StringBuilder(dp[i][j - 1]);
                }
            }
        }

        System.out.print("LCS of " + X + " and " + Y + " is ");
        System.out.print(dp[m][n]);
        return dp[m][n].length();
    }

    int no_Space(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int prevDia = 0;

            for (int j = 1; j <= m; j++) {
                int temp = dp[j];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[j] = 1 + prevDia;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevDia = temp;

            }
        }

        return dp[m];
    }

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

    public int memoiz(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + memoiz(s1, s2, i - 1, j - 1, dp);
        }
        int left = memoiz(s1, s2, i - 1, j, dp);
        int right = memoiz(s1, s2, i, j - 1, dp);

        return dp[i][j] = Math.max(left, right);
    }

    public int rec(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + rec(s1, s2, i - 1, j - 1);
        }
        int left = rec(s1, s2, i - 1, j);
        int right = rec(s1, s2, i, j - 1);

        return Math.max(left, right);
    }
}