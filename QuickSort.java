import java.util.Arrays;
public class QuickSort {
    public static void main(String[] args) {
        //int A[] = {1,8,2,9,4,5,7};
        int A[] = new int[10000000];
        for(int i=0;i<A.length;i++) A[i] = (int)(Math.random()*1000000);
        long t1 = System.currentTimeMillis();
        quickSort(A,0,A.length-1); // 3, 29, 215, 1644, 24460
//        mergeSort(A,0,A.length-1);       // 3, 27, 193, 1695, 16962
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    public static void quickSort(int [] A, int left, int right){
        if (right-left<1) return;
        int pivot = partition(A,left,right);
        quickSort(A,left,pivot-1);
        quickSort(A,pivot+1, right);
    }
    public static int partition(int []A,int left, int right){
        // imrove this function by:
        // 1) selecting better pivot (e.g. median, or middle)
        // 2) do sorting wrt pivot in-place w/o creating extra array B
      
        int pivot = right;
        int B[] = new int [right-left+1];
        int l = 0;
        int r = right-left;

        for(int i=left;i<right;i++){
            if (A[i]<=A[pivot]){
                B[l] = A[i];
                l++;
            } else{
                B[r] = A[i];
                r--;
            }
        }
        B[l] = A[pivot];
        //B[r] = A[pivot];

        for(int k=0;k<B.length;k++){
            A[left+k] = B[k];
        }

        return left+l;
    }

    public static void mergeSort(int []A,int left, int right){
        if (right==left) return;
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

}
