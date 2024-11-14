public class MyHashMap {
    int hash(int key){
        return key%10000;
    }


    ArrayList<Integer> [] keyBucket;
    ArrayList<Integer> [] valBucket;

    public MyHashMap() {
        keyBucket = new ArrayList[10000];
        valBucket = new ArrayList[10000];    
    }
    
    public void put(int key,int value) {
        int index = hash(key);
        if (keyBucket[index]==null){
            keyBucket[index] = new ArrayList<Integer>();
            valBucket[index] = new ArrayList<Integer>();
            keyBucket[index].add(key);
            valBucket[index].add(value);
        } else{
            int i = keyBucket[index].indexOf(key); 
            if (i==-1)
            {
                keyBucket[index].add(key);
                valBucket[index].add(value);
            }else{
                valBucket[index].set(i,value);
            }
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        if (keyBucket[index]!=null){
            int i = keyBucket[index].indexOf(key);
            if (i>=0){
                return valBucket[index].get(i);
            } else return -1;
        } else return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (keyBucket[index]==null) return;


        int i = keyBucket[index].indexOf(key);
        
        if (i>=0){
            keyBucket[index].remove(i);
            valBucket[index].remove(i);
        }
    }
    
}
