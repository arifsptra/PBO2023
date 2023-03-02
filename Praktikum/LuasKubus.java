import java.util.Scanner;

public class LuasKubus {
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);

        // input sisi kubus
        System.out.print("Sisi: ");
        var s = input.nextInt();

        // perhitungan luas kubus
        // luas = 6*(s*s)
        var luas = 6*(s*s);

        // print results
        System.out.println("Luas: " + luas);
    }
}
