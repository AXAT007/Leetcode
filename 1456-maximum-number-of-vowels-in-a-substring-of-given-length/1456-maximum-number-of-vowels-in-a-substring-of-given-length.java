class Solution {
    public int maxVowels(String s, int k) {
        return fxn(s,k);
    }
    public   int fxn(String s,int k){
        int i=0;
        int j=0;
        int currVowel=0;
        int ans=0;
        while(j<s.length()){
            char c=s.charAt(j++);
            if(isVowel(c)){
                currVowel++;
            }
            if(j-i==k){
                ans=Math.max(ans,currVowel);
                if(isVowel(s.charAt(i))){
                    currVowel--;
                }
                i++;
            }
        }
        return ans;
    }

    boolean isVowel(char c ){
        return ( c=='u'|| c=='o'|| c=='i'|| c=='e'|| c=='a');
    }
}