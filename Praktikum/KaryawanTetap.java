public class KaryawanTetap extends Karyawan {
    int gPokok = 10000000;
    int tGaji = 0;

    public void tGaji(int jAnak) {
        tGaji = gPokok + (jAnak*tAnak);
        System.out.println(nama);
        System.out.println("Total Gaji: " + tGaji);
    }
}
