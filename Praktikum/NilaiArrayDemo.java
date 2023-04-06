import java.util.Scanner;

public class NilaiArrayDemo {
    static NilaiArray[] nilai;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i=0, data;

        System.out.print("Ingin input berapa nilai: ");
        data = input.nextInt();
        nilai = new NilaiArray[data];

        while(data!=0) {
            nilai[i] = new NilaiArray();
            System.out.println("\nInput Data Nilai");
            nilai[i].inputNilai();
            nilai[i].hitungNilai();
            i++;
            data--;
        };

        daftarNilai(i);
    }

    static void daftarNilai(int x) {
        System.out.println("\nDaftar Nilai:");
        for(int i=0; i<x; i++) {
            System.out.println("-----");
            nilai[i].cetakNilai();
        }
    }
}
