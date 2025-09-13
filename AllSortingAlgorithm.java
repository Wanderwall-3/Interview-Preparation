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
                // System.out.println(arr[i]+" "+arr[j]);
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
        // System.out.println(Arrays.toString(arr));
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

    public static void countSort(int[] arr, int size) {
        int max = 0;
        for(int i : arr) max = max < i ? i : max;
        int[] tem = new int[max+1];
        for(int i : arr) tem[i] = ++tem[i];
        int ind = 0;
        for(int i=0;i<tem.length;i++){
            while(tem[i]!=0) {
                arr[ind++] = i;
                tem[i] = --tem[i];
            }
        }
    }


    public static void countSortForRadix(int[] arr, int size, int exp) {
        int[] count = new int[10];
        int[] outputTem = new int[size];
        for(int i : arr){
            int particularElement = (i/exp)%(10);
            count[particularElement]++;
        }

        for(int i=0; i<9; i++){
            count[i+1]+=count[i];
        }

        for(int i=size-1; i>=0; i--) {
            outputTem[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        for(int i=0;i<size;i++) arr[i] = outputTem[i];
    }

    public static void radixSort(int[] arr, int size) {
        int max = 0;
        for(int i : arr) max = max < i ? i : max;
        int digitsPosition = 10;
        int exp = 1;
        while(max%digitsPosition > 0){
            countSortForRadix(arr, size, exp);
            exp*=10;
            max/=10;
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
        radixSort(arr,size);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
