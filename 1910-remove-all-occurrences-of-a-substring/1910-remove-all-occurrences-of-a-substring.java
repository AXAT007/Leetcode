class Solution {
    public String removeOccurrences(String s, String part) {
        if(s.length()<part.length()){
            return s;
        }
        int i=0;
        int j=0;
        StringBuilder sb=new StringBuilder();

        while (i<s.length()){
             sb.append(s.charAt(i));
             int t=0;
            if((sb.charAt(sb.length()-1)==part.charAt(part.length()-1)) && sb.length() >=part.length()){
                // StringBuilder temp=new StringBuilder();
                t=sb.length()-1;
                j=part.length()-1;
                while(j>=0 && t>=0){
                    if(sb.charAt(t)==part.charAt(j)){
                        // temp.append(sb.charAt(t));
                        // sb.deleteCharAt(t);
                        t--;
                        j--;
                    }
                    else{
                        break;
                    }
                }
                if(j==-1){
                    sb.setLength(sb.length() - part.length());
                }
            }
            i++;
        }
        return sb.toString();
        }
    }
    
    
    
    
    // public String removeOccurrences(String s, String part) {
    //      while(s.contains(part)){
    //         int idx=s.indexOf(part);
    //         s=(s.substring(0,idx))+s.substring(idx+part.length());
    //     }
    //     return s;
    // }

       
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
// }