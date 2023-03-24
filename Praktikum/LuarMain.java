public class LuarMain {
    public static void main(String[] args) {
        Luar l = new Luar();
        Luar.Tengah t = l.new Tengah();
        Luar.Tengah.Dalam d = t.new Dalam();

        l.cetakLuar();
        t.cetakTengah();
        d.cetakDalam();
    }
}
