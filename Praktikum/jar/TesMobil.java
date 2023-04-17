public class TesMobil {
    public static void main(String[] args) {
        // test method object Mobil
        Mobil avanza = new Mobil();
        Mobil xenia = new Mobil();
        avanza.maju();
        avanza.mundur();
        avanza.belok();
        System.out.println("Roda    : " + avanza.roda);
        System.out.println("Body    : " + avanza.body);
        
        xenia.maju();
        xenia.mundur();
        xenia.belok();
        System.out.println("Roda    : " + xenia.roda);
        System.out.println("Body    : " + xenia.body);
        
        // test method object Mobil2 
        Mobil2 rubicon = new Mobil2();
        rubicon.hidup("rubicon");
        rubicon.mati("rubicon");
        rubicon.ubahGigi("rubicon");
        rubicon.maju();
        rubicon.mundur();
        rubicon.belok();
        System.out.println("Roda    : " + rubicon.roda);
        System.out.println("Body    : " + rubicon.body);
    }
}