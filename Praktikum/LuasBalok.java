import java.util.Scanner;

public class LuasBalok {
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);

        // input panjang lebar
        System.out.print("Panjang lebar: ");
        var pl = input.nextInt();

        // input lebar tinggi
        System.out.print("Lebar tinggi: ");
        var lt = input.nextInt();

        // input panjang tinggi
        System.out.print("Panjang Tinggi: ");
        var pt = input.nextInt();

        // perhitungan luas balok
        // luas = 2*(pl*lt*pt)
        var luas = 2*(pl*lt*pt);

        // print results
        System.out.println("Luas: " + luas);
    }    
}
