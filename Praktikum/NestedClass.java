class NestedClass {
    public static String msg = "Arif Saputra";
    // static nested class
    public static class NestedStaticClass {
        // only static members of Outer class is directly accessible in nested classes
        // static class
        public void printMessage() {
            // try making 'message' a non-static variable, there will be
            // compiler error
            System.out.println("Message from nested static class: " + msg);
        }
    }
    // non-static nested class - also called inner class
    public class InnerClass {
        // both static and non-static members of Outer class are accessible in the Inner class
        public void display() {
            System.out.println("Message from non-static nested class: " + msg);
        }
    }
}
