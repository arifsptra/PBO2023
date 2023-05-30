package hewan;

import java.util.Scanner;

public class Hewan {
    String jenis, ciri;

    public void suara(){
        System.out.println("Suara Hewan");
    }

    public void berjalan(){
        System.out.println("Cara Berjalan Hewan");
    }
}

class Singa extends Hewan {
    @Override
    public void suara(){
        System.out.println("Rawrrrrr");
    }

    @Override
    public void berjalan(){
        System.out.println("Berjalan");
    }
}

class Elang extends Hewan {
    @Override
    public void suara(){
        System.out.println("Cieeeettt");
    }

    @Override
    public void berjalan(){
        System.out.println("Therbang");
    }
}

class Lebah extends Hewan {
    @Override
    public void suara(){
        System.out.println("Ngingngng");
    }

    @Override
    public void berjalan(){
        System.out.println("Terbang");
    }
}

class Paus extends Hewan {
    @Override
    public void suara(){
        System.out.println("Wuhshshshs");
    }

    @Override
    public void berjalan(){
        System.out.println("Berenang");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Hewan singa = new Singa();
        Hewan elang = new Elang();
        Hewan lebah = new Lebah();
        Hewan paus = new Paus();

        while(true){
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
                    break;
                case 2:
                    elang.suara();
                    elang.berjalan();
                    break;
                case 3:
                    lebah.suara();
                    lebah.berjalan();
                    break;
                case 4:
                    paus.suara();
                    paus.berjalan();
                    break;
                case 5:
                    System.exit(choose);
            }
        }
    }
}
