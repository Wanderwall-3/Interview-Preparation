package InterviewPreparation;
import java.util.*;
public class AllSearchingAlgorithm {

    public static void linearSearch(int[] arr, int key) {
        for(int i : arr) {
            if(key == i) {
                System.out.println("Found");
                return;
            }
        }
        System.out.println("Not Found");
    }

    public static void binarySearch(int[] arr, int key, int start, int end) {
        int mid = (start+end)/2;
        if(arr[mid] == key) {
            System.out.println("Found");
            return;
        }
        else if(arr[mid] > key && mid-1 > -1) {
            binarySearch(arr, key, start, mid-1);
            return;
        }
        else if(arr[mid] < key && mid+1 < arr.length) {
            binarySearch(arr, key, mid+1, end);
            return;
        }
        else {
            System.out.println("Not Found");
            return;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        AllSortingAlgorithm.quickSort(arr, 0, size-1);
        System.out.println(Arrays.toString(arr));
        binarySearch(arr, key, 0, size-1);
    }
}
