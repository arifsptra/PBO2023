import java.util.Scanner;

public class NilaiArray {
    Scanner input = new Scanner(System.in);
    String nim, nama;
    float unt, unuts, unuas;
    float nt, nuts, nuas, na;
    char nHuruf;
    String predikat;

    void inputNilai() {
        System.out.print("NIM           : ");
        nim = input.next();
        System.out.print("Nama          : ");
        nama = input.next();
        System.out.print("Nilai Tugas   : ");
        unt = input.nextFloat();
        System.out.print("Nilai UTS     : ");
        unuts = input.nextFloat();
        System.out.print("Nilai UAS     : ");
        unuas = input.nextFloat();
    }

    void hitungNilai() {
        nt = unt * 20/100;
        nuts = unuts * 35/100;
        nuas = unuas * 45/100;
        na = nt + nuts + nuas;
    }
    
    char getNilHuruf(float nilai) {
        char nHuruf;
        if(nilai>=85) {
            nHuruf = 'A';
        }else if(nilai>=70 && nilai<85) {
            nHuruf = 'B';
        }else if(nilai>=60 && nilai<70) {
            nHuruf = 'C';
        }else if(nilai>=60 && nilai<60) {
            nHuruf = 'D';
        }else {
            nHuruf = 'E';
        }
        return nHuruf;
    }

    String getPredikat(char huruf) {
        switch(huruf) {
            case 'A': return "Apik";
            case 'B': return "Baik";
            case 'C': return "Cukup";
            case 'D': return "Dablek";
            default: return "Elek";
        }
    }

    void cetakNilai() {
        System.out.println("NIM           : " + nim);
        System.out.println("Nama          : " + nama);
        System.out.println("Nilai Tugas   : " + unt + " 20%     : " + nt);
        System.out.println("Nilai UTS     : " + unuts + " 35%     : " + nuts);
        System.out.println("Nilai UAS     : " + unuas + " 45%     : " + nuas);
        System.out.println("Nilai Akhir   : " + na);
        System.out.println("Nilai Huruf   : " + getNilHuruf(na));
        System.out.println("Predikat      : " + getPredikat(getNilHuruf(na)));
    }
}
