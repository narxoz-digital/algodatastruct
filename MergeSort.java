import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
//        int A[] = {4,9,2,6,7,2,1,8,3};
        int A[] = new int[10000];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int)(Math.random()*1000000);
        }
        long t1 = System.currentTimeMillis();
//        insertionSort(A); // 40, 3260, (long wait)
        mergeSort(A,0,A.length-1); // 2 3, 21 19, 173 149, 1738 1439, 17203 14973
//        Arrays.sort(A);          // 3, 28, 161, 961, 7601
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    public static void mergeSort(int []A,int left, int right){
        if (right-left<2){
            insertionSort(A,left,right);
            return;
        }

        int middle = (left+right)/2;
        mergeSort(A,left,middle);
        mergeSort(A,middle+1,right);
        merge(A,left,right);
    }
    public static void merge(int []A,int left, int right){
        int middle = (left+right)/2;
        int [] B = new int[right-left + 1];
        int i = left;
        int j = middle+1;
        for(int k=0;k<B.length;k++){
            if (i>middle){
                B[k] = A[j];
                j++;
                continue;
            }
            if (j>right){
                B[k] = A[i];
                i++;
                continue;
            }

            if (A[i]<A[j]){
                B[k] = A[i];
                i++;
            } else {
                B[k] = A[j];
                j++;
            }
        }

        for(int k=0;k<B.length;k++){
            A[left+k] = B[k];
        }
    }
    public static void insertionSort(int []A, int left, int right){
        int n = right+1;
        for(int i=left+1;i<n;i++){
            for(int j=i-1;j>=0 && A[j]>A[j+1];j--){
                int old = A[j];
                A[j] = A[j+1];
                A[j+1] = old;
            }
        }
    }
}
