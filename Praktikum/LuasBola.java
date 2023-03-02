import java.util.Scanner;

public class LuasBola {
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);

        // input jari jari
        System.out.print("Jari Jari: ");
        var r = input.nextInt();

        // declare phi
        final float phi = 3.14f;

        // perhitungan luas bola
        // luas = 4*phi*(r*r*r)
        var luas = 4*phi*(r*r*r);

        // print results
        System.out.println("Luas: " + luas);
    }
}
