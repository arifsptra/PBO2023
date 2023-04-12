import java.util.Scanner;
public class SortingSelectionSort {
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
        selectionSort(number);
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            int j=i;
            for(int z=i+1; z<n; z++) {
                if(arr[z]<arr[j]){
                    j = z;
                }
            }
            swap(arr, j, i);
            
            // print data array per process
            for(int z=0; z<n; z++) {
                System.out.print(arr[z] + " ");
            }
            System.out.println(" ");
        }
    }

    static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
