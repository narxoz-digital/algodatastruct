class MyCircularQueue {
    int []q;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        q = new int[k];
        front = -1;
        rear = -1;        
    }
    
    public boolean enQueue(int value) {
        if (isEmpty()){
            front = 0;
            rear = 0;
            q[0] = value;
           return true; 
        }
        
        if (isFull()){
            // f........r
            // ....rf....
            return false;
        }
        
        if (rear==q.length-1) rear=0;
        else rear++;

        //rear = (rear + 1) % q.length;
        q[rear] = value;
        return true;
        
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        if (rear==front){
            rear = -1;
            front = -1;
            return true;
        }
        
        if (front==q.length-1) front=0;
        else front++;

        // front = (front + 1) % q.length;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return q[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return q[rear];
    }
    
    public boolean isEmpty() {
        return front==-1 && rear==-1;
    }
    
    public boolean isFull() {
        //return ((rear+1) % q.length)==front; // 0 1 2 3 4 (4+1)%5=0 (4+2)%5=1 %5=2 
        return (rear+1 == front || (front==0&&rear==q.length-1));
        // ....rf.....
        //     r+1 = f
        // f.........r
        // f          r+1
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
