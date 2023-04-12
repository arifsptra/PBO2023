import java.util.Scanner;

public class SortingInsertionSort {
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
        insertionSort(number);
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i=1; i<n; i++) {
            int j=i;
            while(j>0 && arr[j-1]>arr[j]) {
                swap(arr, j, j-1);
                j--;
                
                // print data array per process
                for(int z=0; z<n; z++) {
                    System.out.print(arr[z] + " ");
                }
                System.out.println(" ");
            }
        }
    }

    static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
