class Pair{
    int a;
    int wt;
    Pair(int a,int b){
        this.a=a;
        wt=b;
    }
}
class Tuple{
    int a;
    int wt;
    int stops;
    Tuple(int a,int b,int s){
        this.a=a;
        wt=b;
        stops=s;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int [] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int[] i:flights){
            int node=i[0];
            int neigb=i[1];
            int wt=i[2];
            adj.get(node).add(new Pair(neigb,wt));
        }
Queue<Tuple> pq=new ArrayDeque<>();
     pq.offer(new Tuple(src,0,0));

while ( !pq.isEmpty()) {
    int node = pq.peek().a;
    int wt = pq.peek().wt;
    int stop=pq.peek().stops;
    pq.poll();

    for (Pair p : adj.get(node)) {
        int total_wt = wt + p.wt;
 
            if(stop<=k&&cost[p.a]>total_wt){
                cost[p.a]=total_wt;
                pq.offer(new Tuple(p.a, total_wt,stop+1));

            }
    }
} 
if(cost[dst]==Integer.MAX_VALUE) return -1;
return cost[dst];
    }
}