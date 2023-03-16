public class TestStatic {
    int a = 10;
    static int b = 20;
    protected int c = 30;
    public int d = 40;
    private int e = 50;

    void one() {
        two();
        System.out.println("One...");
        System.out.println("One... a : " + a);
        System.out.println("One... b : " + b);
        System.out.println("One... c : " + c);
        System.out.println("One... d : " + d);
        System.out.println("One... e : " + e);
    }

    static void two() {
        // one(); -> error static call non static
        System.out.println("Two...: " + b);
        // System.out.println("Two..." + a); -> error static call var non static
    }

    public static void main(String[] a) {
        // one(); -> error static call non static
        two();
    }
}
