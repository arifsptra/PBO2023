package week10;

public class Mebel {
    int harga;
    String bahan;
}

interface Discountable {
    public void discount(int harga);
}

class Meja extends Mebel {
    int jmlKaki;
}

class MejaMakan extends Meja {
    int jmlKursi;
}

class MejaTamu extends Meja {
    String bentukKaca;

    public void discount(int harga) {
        int discount = harga*10/100;
        System.out.println("Discount : " + discount);
    }
}

class Almari extends Mebel {
    boolean roda;
}

class AlmariMakan extends Almari {
    int jmlRoda;

    public void discount(int harga) {
        int discount = harga*15/100;
        System.out.println("Discount : " + discount);
    }
}

class AlmariPakaian extends Almari {
    int jmlPintu;

    public void discount(int harga) {
        int discount = harga*20/100;
        System.out.println("Discount : " + discount);
    }
}