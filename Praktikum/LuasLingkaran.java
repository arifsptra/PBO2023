import java.util.Scanner;

public class LuasLingkaran {
    public static void main(String[] args) {
        //  scanner object
        Scanner input = new Scanner(System.in);

        // input jari jari
        System.out.print("Jari-Jari: ");
        var r = input.nextInt();

        // declare phi
        final float phi = 3.14f;

        // perhitungan luas lingkaran
        // luas = phi*r*r
        var luas = phi*r*r;

        // print results
        System.out.println("Luas: " + luas);
    }
}
