// Lab 7, Problem 1
import java.util.ArrayList;
public class MyHashSet {
    int hash(int key){
        return key%10000;
    }


    ArrayList<Integer> [] key_bucket;
    public MyHashSet() {
        bucket = new ArrayList[10000];    
    }
    
    public void add(int key) {
        int index = hash(key);
        if (bucket[index]==null){
            bucket[index] = new ArrayList<Integer>();
            bucket[index].add(key);
        } else 
        if (!bucket[index].contains(key))
        {
            bucket[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        if (bucket[index]==null) return;
        int i = bucket[index].indexOf(key);
        
        if (i>=0){
            bucket[index].remove(i);
        }
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return bucket[index]!=null && bucket[index].contains(key);
    }

    
    public static void main(String[] args){
        MyHashSet obj = new MyHashSet();
        obj.add(key);
        obj.remove(key);
        boolean truefalse = obj.contains(key);
    }
}

