import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<PasangIklan> pasangIklanArrayList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while(true) {
            PasangIklan pi = new PasangIklan();
            pi.pasangIklan("Arif");
            pi.setNota();

            pasangIklanArrayList.add(pi);

            System.out.println("\nPasang Iklan Lagi? (y/t) : ");
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
                "No. Nota ", "Nama Pemasang ", "Alamat ", "Produk Iklan ", "Jumlah ", "Durasi ", "Tarif ",
                "Diskon (%) ", "Biaya Iklan ", "Total Biaya ", "Souvenir");

        System.out
                .println(
                        "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i =0; i < pasangIklanArrayList.size(); i++){
            pasangIklanArrayList.get(i).cetak();
        }
    }
}