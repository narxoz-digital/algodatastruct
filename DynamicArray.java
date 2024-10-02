import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

class DynamicArray{
    private int [] A; // capacity = A.length [0,0,0,0,0,0] = 5
    private int size; // [4,5,1, 0, 0] size=3

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("[");
        for (int i = 0; i < size-1; i++) {
            st.append(A[i]+",");
        }
        if (size>0) st.append(A[size-1]);
        st.append("]");
        return st.toString();
    }

    public DynamicArray(){
        this.A = new int[0];
        this.size = 0;
    }

    public DynamicArray(int size){
        if (size<0) throw new RuntimeException("E ti che!");
        this.A = new int[size];
        this.size = size;
    }

    public void add(int item){
        if (size == A.length){
            if (size==0){
                size = 1;
                A = new int[1];
                A[0] = item;
            } else{
                A = Arrays.copyOf(A,size*2);
//                int []B = new int [size*2];
//                for (int i = 0; i < A.length; i++) {
//                    B[i] = A[i];
//                }
//                A = B;
                A[size]=item; // size<A.length
                size++;
            }
        } else{
            A[size]=item; // size<A.length
            size++;
        }


    }
    public void add(int index,int item){
        /*
        Inserts the specified element at the specified position in this list.
         Shifts the element currently at that position (if any) and
          any subsequent elements to the right (adds one to their indices)
         */
    }
    public void remove(int index){} // time O(1), O(n), O(logn)
    public void removeFirst(int item){} // time
    public void removeLast(int item){} // time

    public int get(int index){
        if (index<0 || index >=size) throw new RuntimeException("Eeeeeee!");
        return A[index];
    }
    public void set(int index, int item){

    }
    public int size(){ return size; }
    public int capacity(){ return A.length; }

    public static void main(String[] args) {
        // Vector<Integer> v = new Vector<>(); // thread safe
        // ArrayList<Integer> a = new ArrayList<>();
        // a.add(3,4);
        DynamicArray d = new DynamicArray();
        d.add(25);
        System.out.println(d.size() + " "+ d.capacity()+" "+d);
        d.add(26);
        System.out.println(d.size() + " "+ d.capacity()+" "+d);
        d.add(27);
        System.out.println(d.size() + " "+ d.capacity()+" "+d);
        d.add(28);
        System.out.println(d.size() + " "+ d.capacity()+" "+d);
        d.add(29);
        System.out.println(d.size() + " "+ d.capacity()+" "+d);
    }

}


/* C++ example:

// Example program
#include <iostream>
#include <vector>

using namespace std;

int main()
{
  vector<int> v;
  v.push_back(5);
  v.push_back(6);
  v.push_back(7);
  v.push_back(8);
  v.push_back(9);
  v.push_back(10);

  for(int i=0;i<v.size();i++) cout << v[i] << endl;

  cout << "size = " <<  v.size() << endl;
  cout << "capacity = " <<  v.capacity() << endl;
}
*/

/* output:
5
6
7
8
9
10
size = 6
capacity = 8
 */

