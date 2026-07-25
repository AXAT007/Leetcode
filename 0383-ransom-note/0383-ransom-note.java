class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] map=new int[26];
        for(int i=0;i<magazine.length();i++){
            char c=magazine.charAt(i);
            map[c-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            if(map[c-'a']==0){
                return false;
            }
            else{
                map[c-'a']--;
            }
        }
        return true;
    }
}