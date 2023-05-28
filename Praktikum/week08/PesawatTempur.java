public class PesawatTempur extends Pesawat{
    PesawatTempur(){
        System.out.println("object pesawat tempur dibuat..........");
    }
    void manuver(){
        System.out.println("Manuver..........");
    }
    void terbang(){
        super.terbang();
        System.out.println("Terbang ala tempur..........");
    }
}
