import java.util.Scanner;

public class SecondConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int second;
        char confirm;
        do {
            System.out.print("Input Detik: ");
            second = input.nextInt();
            conversion(second);

            System.out.print("Input data lagi[Y/T] ? ");
            confirm = input.next().charAt(0);
        }while(confirm=='Y' || confirm=='y');
    }   
    static void conversion(int second) {
        int day, hour, minute;
        minute = second/60;
        hour = (minute)/60;
        day = hour/24;
        System.out.println("Day     : " + day);
        System.out.println("Hour    : " + hour);
        System.out.println("Minute  : " + minute);
    }
}
