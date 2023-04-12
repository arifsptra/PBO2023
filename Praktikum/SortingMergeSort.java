import java.util.Scanner;

public class SortingMergeSort {
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
        mergeSort(number, 0, number.length-1);
    }

    static void mergeSort(int[] arr, int l, int r) {
        if(l<r){
            int m = l+(r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            merge(arr, l, m, r);
        }
            
        // print data array per process
        for(int z=0; z<arr.length; z++) {
            System.out.print(arr[z] + " ");
        }
        System.out.println(" ");
    }

    static void merge(int[] arr, int l, int m, int r) {
        // find size of two sub arrays
        int n1 = m-l+1;
        int n2 = r-m;

        // variabel temp array
        int L[] = new int[n1];
        int R[] = new int[n2];

        // copy data to temp array
        for(int i=0; i<n1; i++) {
            L[i] = arr[l+i];
        }
        for(int i=0; i<n2; i++) {
            R[i] = arr[m+1+i];
        }

        // merge the temp array
        int i=0, j=0;
        // initial index of merge subarray array
        int k=l;
        while(i<n1 && j<n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // copy remaining element of L[] if any
        while(i<n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // copy remaining element of R[] if any
        while(j<n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
    
