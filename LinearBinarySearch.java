import java.util.Arrays;

public class LinearBinarySearch {
    public static void main(String[] args) {
        int key = 999999;
        int []A = new int [10000000];
        for(int i=0;i<A.length;i++) A[i] = (int)(Math.random()*1000000);
        Arrays.sort(A);

        long t1 = System.currentTimeMillis();
        int index1 = linearSearch(A,key);
        System.out.println(index1+" -> "+A[index1]);
        long t2 = System.currentTimeMillis();
        System.out.println("time = "+(t2-t1));

        long t3 = System.currentTimeMillis();
        int index2 = binarySearch(A,key);
        System.out.println(index2+" -> "+A[index2]);
        long t4 = System.currentTimeMillis();
        System.out.println("time = "+(t4-t3));


    }

    public static int linearSearch(int[]A, int key){
        for (int i = 0; i < A.length; i++) {
            if (key==A[i]){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[]A, int key){
        int l = 0;
        int r = A.length-1;

        while(l<=r){
            int m = (l+r)/2;
            if (key==A[m]) return m;
            if (key>A[m]) l = m+1;
            else r = m-1;
        }
        return -1;
    }
}
