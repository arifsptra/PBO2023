import java.util.Scanner;

public class SortingBubbleSort {
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
        bubbleSort(number);

        // print last result
        for(int z=0; z<data; z++) {
            System.out.print(number[z] + " ");
        }
    }

    static void bubbleSort(int[] arr) {
        int n=arr.length;
        int temp=0;
        for(int i=0; i<n; i++) {
            for(int z=0; z<n; z++) {
                System.out.print(arr[z] + " ");
            }
            for(int j=1; j<n; j++) {
                if(arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("");
        }
    }
}
