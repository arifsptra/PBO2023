import java.util.Scanner;

public class Determinan {
    static float a, b, c;
    static String siapa;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char j;
        do{
            System.out.print("Determinan siapa: ");
            siapa = input.next();
            System.out.print("Nilai a: ");
            a = input.nextFloat();
            System.out.print("Nilai b: ");
            b = input.nextFloat();
            System.out.print("Nilai c: ");
            c = input.nextFloat();
            abc(determinan(a, b, c));
            System.out.print("Jawab [y/t]: ");
            j = input.next().charAt(0);
        }while(j=='y' || j=='Y');
    }

    static float determinan(float a, float b, float c) {
        float d;
        d = (b*b)-4*a*c;
        return d;
    }

    static void abc(float d){
        float x1=0, x2=0;
        if(d>0){
            x1 = (float)(-b +(Math.sqrt(d)/(2*a)));
            x2 = (float)(-b -(Math.sqrt(d)/(2*a)));
        }else if(d==0){
            x1 = x2 = -b/2*a;
        }else if(d<0){
            x1 = (float)((-b/(2*a)) + (Math.sqrt(-d)/(2*a)));
            x2 = (float)((-b/(2*a)) - (Math.sqrt(-d)/(2*a)));
        }
        System.out.println("a       : "+a);
        System.out.println("b       : "+b);
        System.out.println("c       : "+c);
        System.out.println("D       : "+d);
        System.out.println("x1      : "+x1);
        System.out.println("x2      : "+x2);
    }
}
