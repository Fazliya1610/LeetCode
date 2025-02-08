class NumberContainers {

    Map<Integer, Integer> indexToNumber = new HashMap<>();
    Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();

    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        if(indexToNumber.containsKey(index)) {
            int old = indexToNumber.get(index);
            if(old!=number) {
                numberToIndices.get(old).remove(index);
                if(numberToIndices.get(old).isEmpty()) {
                    numberToIndices.remove(old);
                }
            }
        }
        indexToNumber.put(index, number);
        numberToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        return numberToIndices.containsKey(number)?numberToIndices.get(number).first():-1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */