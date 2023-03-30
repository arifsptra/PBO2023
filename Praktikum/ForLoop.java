import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        forLoopScheme();
    }

    static void forLoopScheme() {
        Scanner input = new Scanner(System.in);
        System.out.print("Bilangan: ");
        int bil = input.nextInt();
        forLoop(bil, 5);
        System.out.print("Dipecah: ");
        int dip = input.nextInt();
        forLoop(bil, dip);
    }

    static void forLoop(int bil, int dip) {
        for(int i=1; i<=bil; i++) {
            System.out.print(i + " ");
            if(i%dip==0){
                System.out.println();
            }
        }
    }
}
