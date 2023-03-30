import java.util.Scanner;

public class Array1 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Jumlah Data: ");
        int jData = input.nextInt();
        int[] aData = new int[100];
        for(int i = 0; i < jData; i++) {
            System.out.print("Data ke - " + (i+1) + " = ");
            aData[i] = input.nextInt();
        }
        for(int i = 0; i < jData; i++) {
            System.out.println("Hasil nilai[" + i + "] = " + aData[i]);
        }
        // input(jData);
        // output(jData);
    }

    // static void input(int jData) {
    // }

    // static void output(int jData) {
    // }
}
