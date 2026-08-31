class Pair{
    int a;
    int wt;
    Pair(int a,int b){
        this.a=a;
        wt=b;
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
Queue<Pair> pq=new ArrayDeque<>();
        // PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(src,0));
int ans = Integer.MAX_VALUE;

while (k > -1 && !pq.isEmpty()) {
    int size=pq.size();
    int[] temp = Arrays.copyOf(cost, n);
    while(size>0){
    int node = pq.peek().a;
    int wt = pq.peek().wt;
    pq.poll();

    for (Pair p : adj.get(node)) {
        int total_wt = wt + p.wt;

        // if (p.a == dst) {
        //     ans = Math.min(ans, total_wt);
        // } else {
            if(cost[p.a]>total_wt){
                temp[p.a]=total_wt;
                pq.offer(new Pair(p.a, total_wt));

            }
        // }
    }
    cost=temp;
    size--;
    }
    k--;
}
ans=cost[dst];
if(ans==Integer.MAX_VALUE) return -1;
return ans;
    }
}