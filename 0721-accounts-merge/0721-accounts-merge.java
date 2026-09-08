
class Solution {

    int[] parent;
    int [] rank;

    int getParent(int u) {
        if (parent[u] == u) {
            return u;
        }

        return parent[u] = getParent(parent[u]);
    }
    boolean union(int u,int v){
         int uu = getParent(u);
         int uv = getParent(v);
        if(uu==uv) return true;
        if(rank[uu]==rank[uv]){
            parent[uv]=uu;
            rank[uu]++;
        }
        else if(rank[uu]>rank[uv]){
            parent[uv]=uu;
        }
        else{
            parent[uu]=uv;
        }
        return false;
    }
    public List<List<String>> accountsMerge(List<List<String>> list) {

        // code here

        int n = list.size();
        parent = new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){

            for (int j = 1; j < list.get(i).size(); j++) {

                String curr = list.get(i).get(j);

                if (map.containsKey(curr)) {
                    union(i,map.get(curr)); 
                }
                else{
                 map.put(curr,i);
                }
            } 
        }
        HashMap<Integer, ArrayList<Integer>> parentList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key=getParent(i);
            if(!parentList.containsKey(key)){
                parentList.put(key, new ArrayList<>());
                
            } 
            parentList.get(key).add(i);
        }

        List<List<String>> ans = new ArrayList<>();
        
        for (Map.Entry<Integer, ArrayList<Integer>> entry : parentList.entrySet()){
            HashSet<String> set=new HashSet<>();
            int k = entry.getKey();
            ArrayList<Integer> val = entry.getValue();
            
            for (int i:val) {
                for (int j=1;j<list.get(i).size();j++ ) {
                    String s=list.get(i).get(j);
                    set.add(s);
                }
            }
            List<String> emails=new ArrayList<>();
            for(String s:set){
                emails.add(s);
            }
            Collections.sort(emails);
            emails.add(0, list.get(k).get(0));
            ans.add(emails);
        }

        return ans;
    }
}