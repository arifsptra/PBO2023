abstract class Computer {
    int harga;
    String deskripsi;
}

class Komputer extends Computer {
    boolean os;
}

class Laptop extends Komputer implements Discountable {
    String merk;

    public void discount(int harga) {}
}

class PC extends Komputer implements Discountable {
    boolean rakitan;

    public void discount(int harga) {}
}

class Monitor extends Computer  {
    int inc;
}

class LCD extends Monitor implements Discountable {
    String merk;

    public void discount(int harga) {}
}

class Analog extends Monitor implements Discountable {
    boolean baru;

    public void discount(int harga) {}
}

class Printer extends Computer {
    int jenis;
}

class DotMetrik extends Printer {
    String type;
}

class Laser extends Printer {
    String merk;
}

class Tinta extends Printer {
    boolean color;
}

interface Discountable {
    public void discount(int harga);
}

public class soal3 {
    public static void main(String[] args) {
        Laptop l = new Laptop();
        l.harga = 20000000;
        l.deskripsi = "this is laptop";
        l.os = true;
        l.merk = "Mac";
        l.discount(10000);

    }
}
