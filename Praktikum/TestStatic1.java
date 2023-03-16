public class TestStatic1 {
    public static void main(String[] args) {
        TestStatic ts = new TestStatic();

        ts.one();
        ts.two();

        System.out.println(ts.a);
        System.out.println(ts.b);
        System.out.println(ts.c);
        System.out.println(ts.d);
        // System.out.println(ts.e); -> cannot call because the variable is private
    }
}
