class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map1 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if((map.containsKey(a)&& map.get(a)!=b)||(map1.containsKey(b)&& map1.get(b)!=a)){
                return false;
            }else{
                map1.put(b,a);
                map.put(a,b);
            }
        }
        return true;
    }
}