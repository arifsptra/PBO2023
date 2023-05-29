import java.util.Scanner;

class TestHewan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Hewan singa = new Singa();
        Hewan elang = new Elang();
        Hewan lebah = new Lebah();
        Hewan paus = new Paus();

        while(true){
            System.out.println("");
            System.out.println("1. Singa");
            System.out.println("2. Elang");
            System.out.println("3. Lebah");
            System.out.println("4. Paus");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda [1-5]: ");
            int choose = input.nextInt();
            switch(choose) {
                case 1:
                    singa.suara();
                    singa.berjalan();
                    singa.bernafas();
                    break;
                case 2:
                    elang.suara();
                    elang.berjalan();
                    elang.bernafas();
                    break;
                case 3:
                    lebah.suara();
                    lebah.berjalan();
                    lebah.bernafas();
                    break;
                case 4:
                    paus.suara();
                    paus.berjalan();
                    paus.bernafas();
                    break;
                case 5:
                    System.exit(choose);
            }
        }
    }
}
