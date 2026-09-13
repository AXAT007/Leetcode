class Solution {
    public String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;
        // char[] arr=new char[s.length()];
char[] arr = s.toCharArray();
        while(i<=j){
            char c = arr[i];
            char d = arr[j];
            
               
            if(!isVowel(Character.toLowerCase(c))){
                i++;
            }
            else if(!isVowel(Character.toLowerCase(d))){
                j--;
            }
            else{
                // char t=arr[i];
                // arr[i]=arr[j];
                // arr[j]=t;
                
                arr[i]=d;
                arr[j]=c;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
    boolean isVowel(char c){
        return c-'a'==0||c-'e'==0||c-'i'==0||c-'o'==0||c-'u'==0;
    }
}