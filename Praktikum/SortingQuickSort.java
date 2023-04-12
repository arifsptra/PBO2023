import java.util.Scanner;

public class SortingQuickSort {
    public static void main(String[] args) {
        // declare variables
        Scanner input = new Scanner(System.in);
        int data;
        int[] number;

        // input data
        System.out.print("Jumlah data: ");
        data = input.nextInt();
        number = new int[data];
        System.out.print("Data: ");
        for(int z=0; z<data; z++) {
            number[z] = input.nextInt();
        }

        // call function for sorting
        quickSort(number, 0, number.length-1);

    }

    static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        // print data array
        for(int z=0; z<arr.length; z++) {
            System.out.print(arr[z] + " ");
        }
        System.out.println(" ");

        int pivot = arr[high];
        int i = low;
        for(int j=low; j<=high-1; j++) {
            if(arr[j] < pivot) {
                swap(arr, j, i); 
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
