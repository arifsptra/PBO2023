public class Factorial {
    public static void main(String[] args) {
        factorial(5);
    }

    static void factorial(int bil) {
        int temp=1;
        System.out.println("Bilangan    : " + bil);
        for(int i=1; i<bil; i++) {
            System.out.print(temp + " x " + (i+1) + " = ");
            temp = temp*(i+1);
            System.out.print(temp + "\n");
        }
    }
}
