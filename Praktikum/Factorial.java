import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bilangan    : ");
        factorial(input.nextInt());
    }

    static void factorial(int bil) {
        int temp=1;
        for(int i=1; i<bil; i++) {
            System.out.print(temp + " x " + (i+1) + " = ");
            temp = temp*(i+1);
            System.out.print(temp + "\n");
        }
    }
}
