class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if(map.containsKey(a)&& map.get(a)!=b){
                return false;
            }else{
                map.put(a,b);
            }
        }
        HashMap<Character, Character> map1 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char b=s.charAt(i);
            char a=t.charAt(i);
            if(map1.containsKey(a)&& map1.get(a)!=b){
                return false;
            }else{
                map1.put(a,b);
            }
        }
        return true;
    }
}