public class Dosen extends Orang {
    private String idDosen;
    private String matkul;
    Dosen() {
        super("Orang");
    }
    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getIdDosen() {
        return idDosen;
    }

    public String getMatkul() {
        return matkul;
    }

    public void cetak() {
        System.out.printf("ID Dosen : " + idDosen);
        System.out.printf("Matkul   : " + matkul);
    }
}
