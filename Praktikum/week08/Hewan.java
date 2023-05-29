import java.util.Scanner;

public class Hewan {
    String jenis, ciri;

    public void suara(){
        System.out.println("Suara Hewan");
    }

    public void berjalan(){
        System.out.println("Cara Berjalan Hewan");
    }

    public void bernafas(){
        System.out.println("Cara Bernafas Hewan");
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

    @Override
    public void bernafas(){
        System.out.println("Paru-Paru");
    }
}

class Elang extends Hewan {
    @Override
    public void suara(){
        System.out.println("Cieeeettt");
    }

    @Override
    public void berjalan(){
        System.out.println("Terbang");
    }

    @Override
    public void bernafas(){
        System.out.println("Paru-Paru");
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

    @Override
    public void bernafas(){
        System.out.println("Trakea");
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

    @Override
    public void bernafas(){
        System.out.println("Paru-Paru");
    }
}