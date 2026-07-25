class Solution {
    public int countCharacters(String[] words, String chars) {
         int [] chaar=new int[26];
        for(int i=0;i<chars.length();i++){
            char c=chars.charAt(i);
            chaar[c-'a']++;
        }
       
            boolean valid=true;

        int ans=0;
        for(int j=0;j<words.length;j++){
            String magazine=words[j];
            int [] word=new int [26];
            for(int i=0;i<magazine.length();i++){
            char c=magazine.charAt(i);
            word[c-'a']++;
             }
             
            valid=true;
            for(int i=0;i<26;i++){
                 if(word[i]>chaar[i]){
                    valid=false;
                    break;
                } 
            }
            
            if(valid){
                ans+=magazine.length();
            }
            
         
        }
        return ans;
    }   
}