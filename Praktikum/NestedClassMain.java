public class NestedClassMain {
    public static void main(String[] args) {
        // nested static class
        NestedClass.NestedStaticClass printer = new NestedClass.NestedStaticClass();
        printer.printMessage();

        // nested non-static class
        NestedClass outer = new NestedClass();
        NestedClass.InnerClass inner = outer.new InnerClass();
        inner.display();
        // or
        // inner class
        NestedClass.InnerClass innerObject = new NestedClass().new InnerClass();
        innerObject.display();
    }
}
