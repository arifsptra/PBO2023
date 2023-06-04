package week10;

public class MebelDemo {
    public static void main(String[] args) {
        MejaMakan mm = new MejaMakan();
        mm.harga = 12000000;
        mm.bahan = "Kayu Rusia";
        mm.jmlKaki = 24;
        mm.jmlKursi = 4;
        
        MejaTamu mt = new MejaTamu();
        mt.harga = 36900000;
        mt.bahan = "Sutra Belanda";
        mt.jmlKaki = 10;
        mt.bentukKaca = "Polygon";
        mt.discount(mt.harga);
        
        AlmariMakan am = new AlmariMakan();
        am.harga = 41850000;
        am.bahan = "Kayu Moldova";
        am.roda = true;
        am.jmlRoda = 8;
        am.discount(am.harga);
        
        AlmariPakaian ap = new AlmariPakaian();
        ap.harga = 98900000;
        ap.bahan = "Kayu Amerika";
        ap.roda = false;
        ap.jmlPintu = 16;
    }
}

