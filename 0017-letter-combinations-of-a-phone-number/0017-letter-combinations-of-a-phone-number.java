class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
    return new ArrayList<>();
}
        HashMap<Integer,String> map=new HashMap<>();
        int count=0;
        for(int i=2;i<=9;i++){
            String s="";
            if(i!=7&&i!=9){
                for(int j=0;j<3;j++){
                    s+=(char) (count+'a') ;
                    count++;
                }
            }
            else{
                for(int j=0;j<4;j++){
                    s+=(char) (count+'a') ;
                    count++;
                }
            }
            map.put(i,s);
        }
        StringBuilder sb=new StringBuilder();
        List<String> ans=new ArrayList<>();
        solve(digits,ans,sb,0,map);
        return ans;
    }

    void solve(String digits,List<String> ans,StringBuilder sb,int j,HashMap<Integer,String> map){
        if(j==digits.length()){
            ans.add(new String(sb.toString()));
            return;
        }

        // map.get( digits.charAt(j) -'0').length()

        String letters = map.get(digits.charAt(j) - '0');
        for(int i=0;i< letters.length();i++){
            
            sb.append(letters.charAt(i));
            solve(digits,ans,sb,j+1,map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}