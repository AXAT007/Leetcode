class MyHashSet {
     ArrayList<ArrayList<Integer>> hashset=new ArrayList<>();
    public MyHashSet() {
       
        for(int i=0;i<10;i++){
            hashset.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int modulo=key%hashset.size();
        boolean b=hashset.get(modulo).contains(Integer.valueOf(key));
        if(!b){
        hashset.get(modulo).add(key);
        }
    }
    
    public void remove(int key) {
        int modulo=key%hashset.size();
        boolean b=hashset.get(modulo).contains(Integer.valueOf(key));
        if(b){ 
        hashset.get(modulo).remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int modulo=key%hashset.size();
        return hashset.get(modulo).contains(Integer.valueOf(key));
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */