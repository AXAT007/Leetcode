class Solution {
    public char repeatedCharacter(String s) {
         // HashMap <Character,Integer> map=new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     char c=s.charAt(i);
        //     map.put(c,map.getOrDefault(c,0)+1);
        // }
        // for(int i=0;i<s.length();i++){
        //     char c=s.charAt(i);
        //     if(map.get(c)==1){
        //         return i;
        //     }
        // }
        int [] arr=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            arr[c-'a']++;
            if(arr[c-'a']>1){
                return c;
            }
            
        }
        return 'l';
    }
}