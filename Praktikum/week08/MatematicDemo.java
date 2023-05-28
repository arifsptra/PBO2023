public class MatematicDemo {
    public static void main(String[] args) {
        Matematic math = new Matematic();
        math.pertambahan(20, 20);
        math.pengurangan(10, 5);
        math.perkalian(10, 20);
        math.pembagian(20, 2);

        System.out.println("---");

        math.pertambahan(10.2f, 11.4f);
        math.pengurangan(10.2f, 11.4f);
        math.perkalian(20.4f, 2.1f);
        math.pembagian(98.3f, 1.2f);

        System.out.println("---");

        math.pertambahan(29.10, 22.3, 32.1);
        math.pengurangan(10.2, 2.1, 4.3);
        math.perkalian(20.4, 2.1, 4.2);
        math.pembagian(30.1, 2.1, 3.2);
    }
}
