class Solution {
    public int countCharacters(String[] words, String chars) {
         int [] chaar=new int[26];
        for(int i=0;i<chars.length();i++){
            char c=chars.charAt(i);
            chaar[c-'a']++;
        }
        int [][] word=new int[words.length][26];
        for(int j=0;j<words.length;j++){
            String magazine=words[j];

            for(int i=0;i<magazine.length();i++){
            char c=magazine.charAt(i);
            word[j][c-'a']++;
             }
        }

        int ans=0;
        for(int j=0;j<words.length;j++){
            int [] temp=word[j];
            int count=0;
            boolean valid=true;
            for(int i=0;i<26;i++){
                if(temp[i]==0&&chaar[i]!=0){}
                else if(temp[i]>chaar[i]){
                    valid=false;
                    break;
                }else{
                    count+=temp[i];
                }
            }
            
            if(valid){
                ans+=count;
            }
            valid=true;
            count=0;
        }
        return ans;
    }   
}