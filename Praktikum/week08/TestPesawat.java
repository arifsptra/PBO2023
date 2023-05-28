public class TestPesawat {
    public static void main(String[] args) {
        Pesawat p = new Pesawat();
        PesawatTempur pt = new PesawatTempur();

        System.out.println("...airbus...");
        p.terbang();
        p.mendarat();

        System.out.println("...f16...");
        pt.terbang();
        pt.mendarat();
        pt.manuver();
    }
}
