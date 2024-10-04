import java.util.ArrayList;
import java.util.Arrays;

public class ResizableArray{
    private int [] A;
    private int size;
    public ResizableArray(){
        size = 0;
        A = new int[0];
    }

    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("[");
        if (size>0) st.append(A[0]);
        for (int i = 1; i < size; i++) {
            st.append(",");
            st.append(A[i]);
        }
        st.append("]");
        return st.toString();
    }
    public void add(int item){
        if (size==0){
            size=1;
            A = new int[1];
            A[size-1] = item;
            return;
        }

        if (size<A.length){
            size++;
            A[size-1]=item;
            return;
        }

        if (size==A.length){
//            int[] B = new int [A.length*2];
//            for (int i = 0; i < A.length; i++) {
//                B[i] = A[i];
//            }
//            A = B;
            A = Arrays.copyOf(A,A.length*2);
            size++;
            A[size-1]=item;
            return;
        }
    }
    public void add(int index, int item){

    }
    public int removeLast(){
        int last = A[size-1];
        size--;
        if (size==A.length/2) {
//            int[] B = new int[A.length/2];
//            for (int i = 0; i < A.length/2; i++) {
//                B[i] = A[i];
//            }
//            A = B;
            A = Arrays.copyOf(A,A.length/2);
        }
        return last;
    }
    public int remove(int index){
        return 0;
    }
    public int get(int index){
        return 0;
    }
    public void set(int index, int item){

    }
    public int size(){
        return size;
    }
    public int capacity() { return A.length;}

    public static void main(String[] args) {
        ResizableArray A = new ResizableArray();
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.add(5);
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.add(7);
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.add(8);
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.add(9);
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.add(4);
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.add(3);
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.add(6);
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.add(2);
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.add(1);
        System.out.println(A.size()+" "+A+" "+A.capacity());
        A.removeLast();
        A.removeLast();
        A.removeLast();
        A.removeLast();
        A.removeLast();
        A.removeLast();
        System.out.println(A.size()+" "+A+" "+A.capacity());
    }
    
}



/*
// Example program
#include <iostream>
#include <vector>

using namespace std;

int main()
{
  vector<int> v;
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  v.push_back(5);
  cout << v.size() << endl;
  cout << v.capacity() << endl;
}
 */
