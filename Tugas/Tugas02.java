public class Tugas02 {
    public static void main(String[] args) {
        // luas persegi
        // variable declarations
        int s=10;
        int luasPersegi;
        int kelilingPersegi;

        // calculate 
        luasPersegi = s*s;
        kelilingPersegi = s*4;

        // print variable
        System.out.println("== Persegi ==");
        System.out.println("Sisi        : " + s);

        // print result
        System.out.println("Luas        : " + luasPersegi);
        System.out.println("Keliling    : " + kelilingPersegi + "\n");

        // =====

        // luas segitiga
        // variable declarations
        int a=10;
        int t=10;
        int sisi1 = 9;
        int sisi2 = 10;
        int sisi3 = 2;
        float luasSegitiga;
        int kelilingSegitiga;
        
        // calculate 
        luasSegitiga = (float) 0.5*a*t;
        kelilingSegitiga = sisi1+sisi2+sisi3;

        // print variable
        System.out.println("== Segitiga ==");
        System.out.println("alas        : " + a);
        System.out.println("tinggi      : " + t);
        System.out.println("sisi 1      : " + sisi1);
        System.out.println("sisi 2      : " + sisi2);
        System.out.println("sisi 3      : " + sisi3);


        // print result
        System.out.println("Luas        : " + luasSegitiga); 
        System.out.println("Keliling    : " + kelilingSegitiga + "\n");    

        // =====

        // luas lingkaran
        // variable declarations
        final float phi = 3.14f;
        int r = 10;
        float luasLingkaran;
        float kelilingLingkaran;

        // calculate
        luasLingkaran = (float) phi*r*r;
        kelilingLingkaran = (float) 2*phi*r;

        // print variable
        System.out.println("== Lingaran ==");
        System.out.println("phi         : " + phi);
        System.out.println("jari-jari   : " + r);
        
        // print result
        System.out.println("Luas        : " + luasLingkaran);
        System.out.println("Keliling    : " + kelilingLingkaran + "\n");

        // =====

        // luas kubus
        // variable declarations
        int sisi = 7;
        int luasKubus;
        int kelilingKubus;

        // calculate
        luasKubus = 6*(sisi*sisi);
        kelilingKubus = 12*(sisi*sisi);

        // print variable
        System.out.println("== Kubus ==");
        System.out.println("sisi        : " + sisi);

        // print result
        System.out.println("Luas        : " + luasKubus);
        System.out.println("Keliling    : " + kelilingKubus);
    }
}
