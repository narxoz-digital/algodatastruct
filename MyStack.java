class MyStack {
    Queue<Integer> stack;
    int size;

    public MyStack() {
        stack = new LinkedList<Integer>();
        size = 0;
    }
    
    public void push(int x) {
        stack.add(x);
        size++;
        // O(1)
    }
    
    public int pop() {
        // 1 2 3 4 5 
        // stack.poll() -> 1
        // 2 3 4 5
        // stack.add(1)
        // 2 3 4 5 1
        // ...
        // 5 1 2 3 4

        for(int i=0;i<size-1;i++){
            stack.add(stack.poll());
        }
        size--;
        return stack.poll();// -> 5, 1 2 3 4, O(stack.size())  
    }
    
    public int top() {
        for(int i=0;i<size-1;i++){
            stack.add(stack.poll());
        }
        // 5 1 2 3 4
        int x = stack.peek();
        // x=5, 5 1 2 3 4
        stack.add(stack.poll());
        // 1 2 3 4 5
        return x; // -> 5
        // O(stack.size())
    }
    
    public boolean empty() {
        return size==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
