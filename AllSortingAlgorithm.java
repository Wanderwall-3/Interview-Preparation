import java.util.*;

public class AllSortingAlgorithm {


    public static void selectionSort(int[] arr, int size) {
        for(int i = 0;i < size; i++){
            int min = arr[i];
            int pos = i;
            for(int j = i+1; j < size; j++){
                if(min > arr[j]){
                    min = arr[j];
                    pos = j;
                }
            }
            int tem = arr[i];
            arr[i] = min;
            arr[pos] = tem;
        }
    }

    public static void insertionSort(int[] arr, int size) {
        for(int i=1; i<size; i++) {
            for(int j=i-1; j>=0; j--){
                if(arr[j]>arr[j+1]){
                    int tem = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]=tem;
                }
            }
        }
    }
 
    public static void quickSort(int[] arr, int start, int end) {           //Reference: https://youtu.be/WprjBK0p6rw?si=x0DxBDkvp5qB24rK
        if(start >= end) return;
        int pivotPos = end;
        int j = start-1;
        for(int i=start; i < end; i++) {
            if(arr[i]<=arr[pivotPos]) {
                System.out.println(arr[i]+" "+arr[j]);
                j++;
                int tem = arr[i];
                arr[i] = arr[j];
                arr[j] = tem;
            }
        }

        int tem = arr[j+1];
        arr[j+1] = arr[pivotPos];
        arr[pivotPos]=tem;
        pivotPos = j+1;
        System.out.println(Arrays.toString(arr));
        quickSort(arr, start, pivotPos-1);
        quickSort(arr, pivotPos+1, end);
    }

    public static void mergeSort(int[] arr,int start, int end, int size) {
        // if(start >= end) return;
        // i++;
        // if(i == 5) return;
        int mid = start + ((end-start)/2);
        if(start<end){
            mergeSort(arr, start, mid, size);
            mergeSort(arr, mid+1, end, size);
        }
        int leftArraySize = mid - start;
        int rightArraySize = end - mid;

        int[] l = new int[leftArraySize];
        int[] r = new int[rightArraySize];

        for(int i = 0; i<leftArraySize; i++) {
            l[i] = arr[start+i];
        }
        for(int i =0; i<rightArraySize; i++) {
            r[i] = arr[mid+1+i];
        }

        int i=0,j=0;
        int ind = start;
        while(i<leftArraySize && j<rightArraySize) {
            if(l[i]<=r[j]){
                arr[ind++]=l[i++];
            }
            else{
                arr[ind++] = r[j++];
            }
        }
        while(i<leftArraySize){
            arr[ind++] = l[i++];
        }
        while (j<rightArraySize) {
            arr[ind++] = r[j++];
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[size];
        String[] str = sc.nextLine().split(" ");
        int ind = 0;
        for(String i : str) arr[ind++] = Integer.parseInt(i);
        mergeSort(arr,0,size-1,size);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
