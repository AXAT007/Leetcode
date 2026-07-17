class Solution {
    public String removeOccurrences(String s, String part) {
         while(s.contains(part)){
            int idx=s.indexOf(part);
            s=(s.substring(0,idx))+s.substring(idx+part.length());
        }
        return s;
    }
       
       /*

       class Solution {
    public String removeOccurrences(String s, String part) {
       for(int i=0;i<s.length();i++){
        if(s.contains(part)){
            s=s.replaceAll(part,"");
            // i=0;    
        }
       }
       return s;
       
       
       
       
        // ArrayDeque<Character> stack=new ArrayDeque<>();
        
        // stack.push(s.charAt(0));
        // int i=1;
        // int j=0;
        // while(i<s.length()){
        //     char first=stack.peek();
        //     if(first==part.charAt(j)){
        //         while(j<part.length()){
        //             char sec=s.charAt(i);
        //             if(first==)
        //         }
        //     }
        //     i++;
        // }
    }
}
       */
       
       
        // ArrayDeque<Character> stack=new ArrayDeque<>();
        
        // stack.push(s.charAt(0));
        // int i=1;
        // int j=0;
        // while(i<s.length()){
        //     char first=stack.peek();
        //     if(first==part.charAt(j)){
        //         while(j<part.length()){
        //             char sec=s.charAt(i);
        //             if(first==)
        //         }
        //     }
        //     i++;
        // }
}