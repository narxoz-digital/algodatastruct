// import java.util.ArrayList;

public class DynamicArray{
    private int [] A;
    private int n;
    public DynamicArray(){
        this.A = new int[4];
        this.n = 0;
    }

    public DynamicArray(int capacity){
        if (capacity<=0) capacity = 4;
        this.A = new int[capacity];
        this.n = 0;
    }

    public int getCapacity(){
        return A.length;
    }

    public int getSize(){
        return n;
    }

    public void add(int x){
        if (n<A.length){
            A[n] = x;
            n++;
        } else{
            // 1) make capacity = capacity + 1;
            // 2) increase by factor of two, capacity = capacity*2;
        }
    }

    public void remove(int index){
        // remove element at index
        // decrease capacity if necessary
    }

    public int get(int index){
        if (index>=0 && index<n) return A[index];
        else throw new ArrayIndexOutOfBoundsException("Che ti!");
    }

    public void set(int index, int item){
        if (index>=0 && index<n) A[index] = item;
        else throw new ArrayIndexOutOfBoundsException("Ti che!");
    }

    public static void main(String[] args) {
        DynamicArray d = new DynamicArray(10);
        // ArrayList<Integer> a = new ArrayList<Integer>(10);

        d.add(7);
        System.out.println(d.get(0));
        d.set(0,5);
        System.out.println(d.get(9));

        System.out.println(d.getSize());
        System.out.println(d.getCapacity());

    }
}

/* Dynamic array in C++
#include <iostream>
#include <vector>

using namespace std;
int main()
{
  vector<int> v(10);
  cout << v.capacity() << endl; // 10
}

*/
