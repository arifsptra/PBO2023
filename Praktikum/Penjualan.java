import java.util.Scanner;

public class Penjualan {
    static Scanner input = new Scanner(System.in);
    static String kode;
    static String nama;
    static float harga;
    static int jumlah;
    static float total;
    static char confirm;
    public static void main(String[] args) {
        do {
            setData();
            getTotalPembelian();
            getBonus();
            cetakNota();

            System.out.print("Input data lagi[Y/T] ? ");
            confirm = input.next().charAt(0);
            System.out.println();
        }while(confirm=='Y' || confirm=='y');
    }

    static void setData() {
        System.out.print("Kode      : ");
        kode = input.next();
        System.out.print("Nama      : ");
        nama = input.next();
        System.out.print("Harga     : ");
        harga = input.nextFloat();
        System.out.print("Jumlah    : ");
        jumlah = input.nextInt();
        total = harga*jumlah;
    }

    static void getTotalPembelian() {
        System.out.println("Total Pembelian: " + total + "\n");
    }

    static void getBonus() {
        if(total>=500000 && jumlah>5) {
            System.out.println("Anda mendapatkan Setrika!");
        }else if(total>=100000 && jumlah>3) {
            System.out.println("Anda mendapatkan Payung!");
        }else if(total>=50000 && jumlah>2) {
            System.out.println("Anda mendapatkan ballpoint!");
        }else {
            System.out.println("Anda tidak mendapatkan bonus!");
        }
    }

    static void cetakNota() {
        System.out.println("\n==== Nota ====");
        System.out.println("Kode    : " + kode);
        System.out.println("Nama    : " + nama);
        System.out.println("Harga   : " + harga);
        System.out.println("Jumlah  : " + jumlah);
        System.out.println("Total   : " + total);
        System.out.println("================");
    }
}
