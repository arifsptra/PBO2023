import java.util.Scanner;

public class SuhuConversion {
    public static void main(String[] args) {
        // initialize
        Scanner input = new Scanner(System.in);
        float celcius = input.nextFloat();
        // print celcius value
        System.out.println("Celcius       : " + celcius);

        // convert celcius to kelvin
        System.out.print("Kelvin        : ");
        System.out.println(kelvin(celcius));
        // convert celcius to fahrenheit
        System.out.print("Fahrenheit    : ");
        System.out.println(fahrenheit(celcius));
        // convert celcius to rankie
        System.out.print("Rankie        : ");
        System.out.println(rankine(celcius));
        // convert celcius to delisle
        System.out.print("Delisle       : ");
        System.out.println(delisle(celcius));
        // convert celcius to newton
        System.out.print("Newton        : ");
        System.out.println(newton(celcius));
        // convert celcius to reaumur
        System.out.print("Reaumur       : ");
        System.out.println(reaumur(celcius));
        // convert celcius to romer
        System.out.print("Romer         : ");
        System.out.println(romer(celcius));
    }

    // method for conversion from celcius to kelvin
    static float kelvin(float celcius) {
        return celcius + 273.15f;
    }

    // method for conversion from celcius to fahrenheit
    static float fahrenheit(float celcius) {
        return celcius * 1.8f + 32;
    }

    // method for conversion from celcius to rankine
    static float rankine(float celcius) {
        return celcius + 1.8f + 491.67f;
    }

    // method for conversion from celcius to delisle
    static float delisle(float celcius) {
        return (100-celcius) * 1.5f;
    }

    // method for conversion from celcius to newton
    static float newton(float celcius) {
        return celcius * 33 / 100;
    }

    // method for conversion from celcius to reaumur
    static float reaumur(float celcius) {
        return celcius * 0.8f;
    }

    // method for conversion from celcius to romer
    static float romer(float celcius) {
        return celcius * 21/40 + 7.5f;
    }
}
