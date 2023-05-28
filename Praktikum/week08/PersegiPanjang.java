public class PersegiPanjang {
    double p, l, luas;
    void hitungLuas(){
        luas = p*l;
    }
    void cetak(){
        System.out.println("Panjang\t: "+p);
        System.out.println("Lebar\t: "+l);
        System.out.println("Luas\t: "+luas);
    }
}