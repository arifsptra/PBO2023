import java.util.ArrayList;
import java.util.Scanner;
public class PerdanaDemo {
    public static void main(String[] args) {
        ArrayList<Grosir> grosirs = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while(true) {
            Grosir g = new Grosir("Human");
            g.setNota();

            grosirs.add(g);

            System.out.print("\nBeli Lagi? (y/t) : ");
            String choice = input.next();

            if(choice.equals("y")){
                continue;
            } else if(choice.equals("t")){
                break;
            }
        }
        // cetak
        System.out
                .println(
                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                "No. Nota ", "Barcode ", "Nama Produk ", "Harga Jual ", "Jumlah ", "Total ","Ket Bayar ",
                "PPN ", "Bunga ", "Total Bayar ", "Souvenir");

        System.out
                .println(
                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i =0; i < grosirs.size(); i++){
            grosirs.get(i).cetak();
        }
    }
}