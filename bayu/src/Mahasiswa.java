public class Mahasiswa extends Orang{
    private String nim;
    private String progdi;

    Mahasiswa() {
        super("Orang");
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setProgdi(String progdi) {
        this.progdi = progdi;
    }

    public String getNim() {
        return nim;
    }

    public String getProgdi() {
        return progdi;
    }

    public void cetak() {
        System.out.printf("NIM      : " + nim);
        System.out.printf("Progdi   : " + progdi);
    }
}
