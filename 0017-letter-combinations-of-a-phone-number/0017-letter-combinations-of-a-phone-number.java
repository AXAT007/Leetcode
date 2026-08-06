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
        List<String> ans=solve(digits,sb,0);
        
        return ans;
    }

    List<String> solve(String digits,StringBuilder sb,int j){
        List<String> ans=new ArrayList<>();
        if(j==digits.length()){
            ans.add( sb.toString());
            return ans;
        }

        String letters = map[digits.charAt(j) - '0'];
        for(int i=0;i< letters.length();i++){
            
            sb.append(letters.charAt(i));
            ans.addAll(solve(digits,sb,j+1));
            sb.deleteCharAt(sb.length() - 1);
        }
        return ans;
    }
}