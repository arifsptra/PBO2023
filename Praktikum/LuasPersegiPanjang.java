import java.util.Scanner;

public class LuasPersegiPanjang {
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);

        // input panjang persegi panjang
        System.out.print("Panjang: ");
        var p = input.nextInt();

        // input luas persegi panjang
        System.out.print("Lebar: ");
        var l = input.nextInt();

        // perhitungan luas persegi panjang
        // luas = panjang*lebar
        var luas = p*l;
        System.out.println("Luas: " + luas);
    }    
}
