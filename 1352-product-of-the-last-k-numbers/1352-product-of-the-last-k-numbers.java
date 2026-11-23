class ProductOfNumbers {
    List<Integer> l = new ArrayList<>();
    int lastZeroIdx = -1;

    public ProductOfNumbers() {
       l.add(1);
        
    }
    
    public void add(int num) {
        
       if (num == 0) {
            l.add(0);
            lastZeroIdx = l.size() - 1;
        } else {
            int prev = l.get(l.size() - 1);
           
            l.add(prev == 0 ? num : prev * num);
        }
    
        
    }
    
    public int getProduct(int k) {
    int startIdx = l.size() - k;
        
      
        if (lastZeroIdx >= startIdx) {
            return 0;
        }
        
        int last = l.get(l.size() - 1);
        int before = l.get(startIdx - 1);
        
       
        return before == 0 ? last : last / before;
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */