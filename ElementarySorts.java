import java.util.Arrays;

public class ElementarySorts {
    public static void main(String[] args) {
//        int A[] = {4,3,8,7,5,1,2,6};
        int []A = new int [10000];
        for(int i=0;i<A.length;i++) A[i] = (int)(Math.random()*1000000);

        long t1 = System.currentTimeMillis();

//        bubbleSort(A);    // 5, 140, 17478, (long wait)
//        selectionSort(A); // 2,  64,  5628, (long wait)
        insertionSort(A); // 3,  27,  1691, (long wait)
//        Arrays.sort(A); // 7885
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

    }

    public static void insertionSort(int []A){
        int n = A.length;
        for(int i=1;i<n;i++){
            for(int j=i; j>0 && A[j]<A[j-1]; j--){
                int old = A[j];
                A[j] = A[j-1];
                A[j-1] = old;
            }
        }
    }

    public static void bubbleSort(int []A){
        int n = A.length;
        for(int i=0;i<n-1;i++)
            for(int j=0;j<n-1-i;j++){
                if (A[j]>A[j+1]){
                    int old = A[j];
                    A[j] = A[j+1];
                    A[j+1] = old;
                }
            }
    }

    public static void selectionSort(int []A){
        int n = A.length;
        for(int i=0;i<n-1;i++) {
            int m = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[m]) {
                    m = j;
                }
            }
            int old = A[i];
            A[i] = A[m];
            A[m] = old;
        }
    }
}
