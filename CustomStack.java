class CustomStack {
    ArrayList<Integer> stack;
    int maxSize;

    CustomStack(int maxSize) {
        stack = new ArrayList(maxSize);
        this.maxSize = maxSize;
    }
    
    void push(int x) {
        if (maxSize==stack.size()) return;
        stack.add(x);
    }

    
    int pop() {
       if (stack.size()==0) return -1;
       return stack.remove(stack.size()-1); 
    }
    
    void increment(int k, int val) {
        for(int i=0;i<k && i<stack.size(); i++){
            stack.set(i,stack.get(i)+val);
        }
    }
}
