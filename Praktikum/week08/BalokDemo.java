public class BalokDemo {
    public static void main(String[] args) {
        Balok b = new Balok();
        b.p = 10;
        b.l = 5;
        b.t = 5;
        b.hitungLuas();
        b.hitungVolume();
        b.cetak();

        System.out.println(" ");
        b.l = 7;
        b.hitungLuas();
        b.hitungVolume();
        b.cetak("Balokku");
    }
}
