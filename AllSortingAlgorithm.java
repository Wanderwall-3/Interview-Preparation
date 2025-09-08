package InterviewPreparation;
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
 
    public static void quickSort(int[] arr, int start, int end) {           //Reference: https://youtu.be/WprjBK0p6rw?si=x0DxBDkvp5qB24rK
        if(start >= end) return;
        int pivotPos = end;
        int j = start-1;
        for(int i=start; i < end; i++) {
            if(arr[i]<=arr[pivotPos]) {
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

    public static void insertionSort(int[] arr, int size) {
        for(int i=1; i <= size; i++) {
            int pos = i;
            for(int j=i-1; j>=0; j--) {
                if(arr[pos] <= arr[j]) {
                    int tem = arr[pos];
                    arr[pos] = arr[j];
                    arr[j] = tem;
                    pos = j;
                }
            }
        }
        System.out.println("Insertion sort Process complete");
    }

    public static void mergeSort(int[] arr, int size) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[size];
        String[] str = sc.nextLine().split(" ");
        int ind = 0;
        for(String i : str) arr[ind++] = Integer.parseInt(i);
        quickSort(arr,0,size-1);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
