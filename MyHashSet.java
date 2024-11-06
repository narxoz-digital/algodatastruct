import java.util.ArrayList;
import java.util.Arrays;

public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet s = new MyHashSet();
        s.add(3234567); // 234567
        s.add(1234567); // 234567
        s.add(1234568); // 234568
        s.add(1234000); // 234000
        s.add(1234025); // 234025
        System.out.println(Arrays.toString(s.toArray()));
    }

    ArrayList<Integer> [] bucket;
    int size;
    public MyHashSet(){
        bucket = new ArrayList[1000000];
        size = 0;
    }

    public void add(int x){
        int hash = x%1000000;
        if (bucket[hash]==null) bucket[hash] = new ArrayList<Integer>();
        if (!bucket[hash].contains(x)){
            bucket[hash].add(x);
            size++;
        }
    }

    public void remove(int x){
        int hash = x%1000000;
        if (bucket[hash]==null) return;
        int index = bucket[hash].indexOf(x);
        if (index>=0) {
            bucket[hash].remove(index);
            size--;
        }
    }

    public int[] toArray(){
        int [] array = new int[size];
        int k = 0;
        for(int i=0;i<1000000;i++){
            if (bucket[i]!=null && !bucket[i].isEmpty()){
                for (int j = 0; j < bucket[i].size(); j++) {
                    array[k++] = bucket[i].get(j);
                }
            }
        }
        return array;
    }
}
