import java.util.Arrays;

public class SortingAlgorithm {

    public static void selectionSort(int[] arr, int size) {
        int min = 0, pos = 0;
        for(int i=0; i<size && (min=arr[i])==min && (pos=i)==pos; i++) {
            for(int j = i+1; j<size; j++) if(min > arr[j] && (min=arr[j]) == min && (pos = j) == pos );
            if(pos != i) {
                int temp = arr[i];
                arr[i] = arr[pos]; 
                arr[pos] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr, int size) {
        for(int i=1; i<size; i++) {
            for(int j=i; j>0 && arr[j-1] > arr[j]; j--) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    public static void quickSort(int[] arr, int size) {
        System.out.println("pass");
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,0,2,1};
        int size = arr.length;
        insertionSort(arr, size);
        System.out.println(Arrays.toString(arr));
    }
}