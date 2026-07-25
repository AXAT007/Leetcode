class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            char c=ransomNote.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char c=magazine.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        for(char c:map.keySet()){
            if(map.containsKey(c)&& !map2.containsKey(c)){
                return false;
            }
            if(map.get(c)>map2.get(c)){
                return false;
            }
        }
        return true;


    }
}