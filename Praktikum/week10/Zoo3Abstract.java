package week10;

abstract class Binatang {
    abstract void makan();
    abstract void tidur();
    void mati() {
        System.out.println("Mati..........");
    }
}

class Harimau extends Binatang {
    void makan() {
        System.out.println("Harimau Makan..........");
    }
    void tidur() {
        System.out.println("Harimau tidur..........");
    }
}

class Bebek extends Binatang {
    void makan() {
        System.out.println("Bebek Makan..........");
    }
    void tidur() {
        System.out.println("Bebek tidur..........");
    }
}

public class Zoo3Abstract {
    static void test(Binatang a){
        a.makan();
        a.tidur();
        a.mati();
    }
    public static void main(String[] args) {
        Harimau macan = new Harimau();
        Bebek donald = new Bebek();

        // Binatang b = new Binatang(); -> error abstract class tidak bisa dibuat objek

        test(macan);
        test(donald);
    }
}
