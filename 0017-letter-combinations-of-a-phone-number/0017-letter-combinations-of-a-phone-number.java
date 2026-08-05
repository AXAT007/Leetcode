class Solution {
    String[] map = {
        "",     
        "",     
        "abc", 
        "def",  
        "ghi",  
        "jkl",  
        "mno",  
        "pqrs",
        "tuv",  
        "wxyz" 
    };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
    return new ArrayList<>();
}
    
        StringBuilder sb=new StringBuilder();
        List<String> ans=new ArrayList<>();
        solve(digits,ans,sb,0);
        return ans;
    }

    void solve(String digits,List<String> ans,StringBuilder sb,int j){
        if(j==digits.length()){
            ans.add( sb.toString());
            return;
        }

        String letters = map[digits.charAt(j) - '0'];
        for(int i=0;i< letters.length();i++){
            
            sb.append(letters.charAt(i));
            solve(digits,ans,sb,j+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}