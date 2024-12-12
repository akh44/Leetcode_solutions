class TimeMap {

    private Map<String, TreeMap<Integer,String>> store;

    public TimeMap() {
        this.store=new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key,new TreeMap<>());
        store.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key))
        {
            return "";
        }

        TreeMap<Integer,String> timeMap=store.get(key);
        Integer closestTimeStamp=timeMap.floorKey(timestamp);
        if(closestTimeStamp==null)
        {
            return "";
        }

        return timeMap.get(closestTimeStamp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */