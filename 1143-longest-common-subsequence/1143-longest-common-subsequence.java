class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp=new int[text1.length()][text2.length()];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        return memoiz(text1,text2,text1.length()-1,text2.length()-1,dp);
        // return rec(text1,text2,text1.length()-1,text2.length()-1);

        
    }

    
    public int memoiz(String s1, String s2, int i, int j,int [][] dp) {
        if(i<0|| j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
    if (s1.charAt(i) == s2.charAt(j)) {
        return dp[i][j]= 1+ memoiz(s1, s2, i - 1, j-1,dp);
    }
    int left = memoiz(s1, s2, i - 1, j,dp);
    int right = memoiz(s1, s2, i, j - 1,dp);

    return dp[i][j]= Math.max(left, right);
}

    public int rec(String s1, String s2, int i, int j) {
        if(i<0|| j<0) return 0;
    if (s1.charAt(i) == s2.charAt(j)) {
        return 1+ rec(s1, s2, i - 1, j-1);
    }
    int left = rec(s1, s2, i - 1, j);
    int right = rec(s1, s2, i, j - 1);

    return Math.max(left, right);
}
}