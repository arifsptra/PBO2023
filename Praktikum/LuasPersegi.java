import java.util.Scanner;

public class LuasPersegi {
    public static void main(String[] args) {
        // scanner object
        Scanner input = new Scanner(System.in);

        // input sisi persegi
        System.out.print("Sisi: ");
        var s = input.nextInt();

        // perhitungan luas persegi
        // luas = sisi*sisi
        var luas = s*s;

        // print result
        System.out.println("Luas: " + luas);
    }    
}