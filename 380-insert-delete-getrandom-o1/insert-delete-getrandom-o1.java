class RandomizedSet {

    private List<Integer> elements;
    private Map<Integer, Integer> eleToIndex;

    public RandomizedSet() {
        elements = new ArrayList<>();
        eleToIndex = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(eleToIndex.containsKey(val)) {
            return false;
        }
        eleToIndex.put(val, elements.size());
        elements.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!eleToIndex.containsKey(val)) {
            return false;
        }
        int index = eleToIndex.get(val);
        int last = elements.get(elements.size()-1);
        elements.set(index,last);
        eleToIndex.put(last, index);
        elements.remove(elements.size()-1);
        eleToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random r = new Random();
        int index = r.nextInt(elements.size());
        return elements.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */