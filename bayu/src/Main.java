public class Main {
    public static void main(String[] args) {
//        Orang o = new Orang();
//
//        o.setNama("Arif Saputra");
//        o.setUsia(19);
//        o.setGender('L');

        Mahasiswa m = new Mahasiswa();
        m.setNama("Sapto");
        m.setUsia(19);
        m.setGender('L');
        m.setNim("A12");
        m.setProgdi("Sistem Informasi");

        Dosen d = new Dosen();
        d.setNama("Arif");
        d.setUsia(19);
        d.setGender('L');
        d.setIdDosen("112.331");
        d.setMatkul("Fisika");

        // cetak identitas
        System.out.println("Mahasiswa");
        System.out.println(m.getNama());
        System.out.println(m.getUsia());
        System.out.println(m.getGender());
        System.out.println(m.getNim());
        System.out.println(m.getProgdi());

        System.out.println("\nDosen");
        System.out.println(d.getNama());
        System.out.println(d.getUsia());
        System.out.println(d.getGender());
        System.out.println(d.getIdDosen());
        System.out.println(d.getMatkul());
    }
}