import java.util.Scanner;

public class LuasTrapesium {
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);

        // input panjang sisi alas
        System.out.print("Panjang Sisi Alas: ");
        var a = input.nextInt();

        // input pajang sisi b
        System.out.print("Panjang Sisi B: ");
        var b = input.nextInt();

        // input tinggi
        System.out.print("Tinggi: ");
        var t = input.nextInt();

        // perhitungan luas trapesium
        // luas = 1/2*(a*b)*t
        var luas = 0.5*(a*b)*t;

        // print results
        System.out.println("Luas: " + luas);
    }
}
