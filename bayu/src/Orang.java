public class Orang {
    private String nama;
    private int usia;
    private char gender;

    public Orang(String orang) {
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setUsia(int usia) {
        this.usia = usia;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getNama() {
        return nama;
    }
    public int getUsia() {
        return usia;
    }
    public char getGender() {
        return gender;
    }

    public void cetak() {
        System.out.println("Nama    : " + nama);
        System.out.println("Usia    : " + usia);
        System.out.println("Gender  : " + gender);
    }
}

