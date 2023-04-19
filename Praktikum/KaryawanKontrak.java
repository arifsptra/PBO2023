public class KaryawanKontrak extends Karyawan {
    int gHarian = 350000;
    int tGaji = 0;

    public void tGaji(int hMasuk, int jAnak) {
        tGaji = (gHarian*hMasuk) + (jAnak*tAnak);
        System.out.println(nama);
        System.out.println("Total Gaji: " + tGaji);
    }
}
