package week10;

class Handphone extends Telepon implements Kamera, Radio {
    private String gelombang;
    private float pixel;
    public void ambilGambar(){
        System.out.println("Gambar terambil...");
    }
    public void setGelombang(String gel){
        this.gelombang=gel;
    }
    public void setPixel(float pixel){
        this.pixel=pixel;
    }
    public void setNomor(long no){
        this.nomer=no;
    }
}
