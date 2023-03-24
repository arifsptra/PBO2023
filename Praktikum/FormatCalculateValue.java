import java.util.Scanner;

public class FormatCalculateValue {
    String nim;
    String nama;
    float uts;
    float tugas;
    float uas;
    float futs;
    float ftugas;
    float fuas;
    float na;

    Scanner input = new Scanner(System.in);

    void input() {
        System.out.println("");
        System.out.print("NIM           : ");
        nim = input.next();
        
        System.out.print("Nama          : ");
        nama = input.next();
        
        System.out.print("Value UTS     : ");
        uts = input.nextFloat();
        
        System.out.print("Value Tugas   : ");
        tugas = input.nextFloat();
        
        System.out.print("Value UAS     : ");
        uas = input.nextFloat();
    }

    void calculate() {
        this.futs = uts*20/100;
        this.ftugas = tugas*35/100;
        this.fuas = uas*45/100;

        this.na = futs + ftugas + fuas;
    }

    void print() {
        System.out.println("");
        System.out.println("NIM           : " + nim);
        System.out.println("Nama          : " + nama);
        System.out.println("Final UTS     : " + futs);
        System.out.println("Final Tugas   : " + ftugas);
        System.out.println("Final UAS     : " + fuas);
        System.out.println("Final Value   : " + na);
    }
}
