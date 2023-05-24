package KisiKisiUTS;

import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;

public class PasangIklan extends Iklan {
    static int noNota, jmlIklan, durasi, diskon, biayaIklan, ppn, totBiaya;
    static String nama, alamat, souvenir;
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        menu();
        // Iklan iklan = new Iklan();
        // System.out.println("Iklan Cetak - Arif Saputra\n");
        // System.out.print("No. Nota    : ");
        
        // System.out.println("Nama Pemasang   : ");
        // System.out.println("Alamat          : ");
        // System.out.println("Kode Produk     : ");
        // System.out.println("Produk Iklan    : ");
        // System.out.println("Tarif Iklan     : ");
        // if() {
        //     System.out.println("Jml. Baris      : ");   
        // }else {
        //     System.out.println("Luas (mmk)      : ");   
        // }
    }

    public static void pasangIklan(String cabang) {

    }

    public static void menu() {
        int menu;
        System.out.println("1. Input Iklan");
        System.out.println("2. Cetak Iklan");
        System.out.println("3. Exit");
        menu = input.nextInt();
        switch(menu) {
            case 1: setNota();
            case 2: cetak();
            case 3: System.exit(menu);
            default: System.out.println("Your Input, Not Correct!");
        }
    }

    public static void setNota() {}

    public static void inputJumlah() {}

    public static void getTarifIklan() {}

    public static void inputDurasi() {}

    public static void getDiskon() {}

    public static void getBiayaIklan() {}

    public static void getSouvenir() {}

    public static void getTotal() {}

    public static void cetak() {}
}
