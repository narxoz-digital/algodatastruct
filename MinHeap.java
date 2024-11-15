import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinHeap {
    ArrayList<Integer> heap;
    MinHeap(){
        heap = new ArrayList<>();
    }

    int getMin(){
        // make heap great again
        return heap.get(0);
    }

    int removeMin(){
        if (heap.size()==1) return heap.removeLast();

        int x = heap.get(0);
        heap.set(0,heap.removeLast());
        int i = 0;
        while(true){
            if (2*i+1>heap.size()-1) break;

            if (2*i+2>heap.size()-1){
                if (heap.get(i)>heap.get(2*i+1)){
                    int t = heap.get(i);
                    heap.set(i,heap.get(2*i+1));
                    heap.set(2*i+1,t);
                    i = 2*i+1;
                    continue;
                } else
                    break;
            }

            if (heap.get(i)>heap.get(2*i+1) || heap.get(i)>heap.get(2*i+2)){
                if (heap.get(2*i+1) < heap.get(2*i+2)){
                    int t = heap.get(i);
                    heap.set(i,heap.get(2*i+1));
                    heap.set(2*i+1,t);
                    i = 2*i+1;
                    continue;
                } else{
                    int t = heap.get(i);
                    heap.set(i,heap.get(2*i+2));
                    heap.set(2*i+2,t);
                    i=2*i+2;
                    continue;
                }
            } else
                break;
        }

        return x;
    }

    void add(int x){
        heap.add(x);
        // make heap great again
        int i = heap.size()-1;
        while(i!=0){
            if (heap.get(i)<heap.get((i-1)/2)){
                int t = heap.get(i);
                heap.set(i,heap.get((i-1)/2));
                heap.set((i-1)/2,t);
                i = (i-1)/2;
            } else
                break;
        }
    }

    boolean isEmpty(){
        return heap.size()==0;
    }



    public static void main(String[] args) {
      MinHeap h = new MinHeap();
      // PriorityQueue<Integer> h = new PriorityQueue<>();
      h.add(5);
      h.add(7);
      h.add(1);
      h.add(4);
      h.add(3);
      h.add(2);
      h.add(8);
      while (!h.isEmpty()){
          System.out.print(h.removeMin()+" ");
          // System.out.print(h.remove()+" ");
      }
    }
}
