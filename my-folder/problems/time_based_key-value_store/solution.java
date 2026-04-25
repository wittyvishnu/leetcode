class TimeMap {
    TreeMap<Integer,String> tree;
    HashMap<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        tree=new TreeMap<>();
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<Integer,String>());
        }
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        TreeMap<Integer, String> treeMap = map.get(key);
        
        Integer floor = treeMap.floorKey(timestamp); 
        
        if (floor == null) return "";
        
        return treeMap.get(floor);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */