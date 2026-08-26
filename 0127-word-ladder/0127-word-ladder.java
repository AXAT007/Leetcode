class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q=new ArrayDeque<>();
        q.offer(beginWord);
        int lvl=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                String s=q.poll();
                for(int i=0;i<s.length();i++){
                    for(char c='a';c<='z';c++){
                        String curr=s.substring(0,i)+c+s.substring(i+1,s.length());
                        if(endWord.equals(curr)){
                            return lvl+1; 
                        }
                        if(set.contains(curr)){
                            q.offer(curr);
                        }
                        set.remove(curr);
                    }
                }
                size--;
            }
            lvl++;
        }
        return 0;
    }
}