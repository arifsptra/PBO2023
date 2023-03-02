import java.util.Scanner;

public class LuasSegitiga {
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);
        
        // input alas segitiga
        System.out.print("Alas: ");
        var a = input.nextInt();

        // input tinggi segitiga
        System.out.print("Tinggi: ");
        var t = input.nextInt();

        // perhitungan luas segitiga
        // luas = 1/2*alas*tinggi
        var luas = 0.5*a*t;

        // print results
        System.out.println("Luas: " + luas);
    }
}
