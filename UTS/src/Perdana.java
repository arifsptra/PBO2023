import java.util.Scanner;

public class Perdana {
    String barCode, nmKartu;
    int hrgBeli, hrgJual;
    Scanner input = new Scanner(System.in);
    public void inputPerdana() {
        System.out.print("Barcode       : ");
        barCode = input.next();

        System.out.print("Nama Produk   : ");
        nmKartu = input.next();

        System.out.print("Harga Beli    : ");
        hrgBeli = input.nextInt();

        if(hrgBeli > 200000) {
            hrgJual = hrgBeli + (hrgBeli*50/100);
        }else if(hrgBeli > 100000) {
            hrgJual = hrgBeli + (hrgBeli*75/100);
        }else if(hrgBeli > 50000){
            hrgJual = hrgBeli + (hrgBeli*100/100);
        }else if(hrgBeli > 25000){
            hrgJual = hrgBeli + (hrgBeli*150/100);
        }else if(hrgBeli < 25000) {
            hrgJual = hrgBeli + (hrgBeli*200/100);
        }

        System.out.println("Harga Jual    : " + hrgJual);
    }
}

class Grosir extends Perdana {
    int noNota, jmlJual, totJual, jnsByr, ppn, bunga, totByr, wktTmp;
    String ketByr, souvenir;
    Scanner input = new Scanner(System.in);

    Grosir(String cabang) {
        System.out.println("Grosir Kartu Perdana - " + cabang + "\n");
    }

    void setNota() {
        noNota+=1;
        System.out.println("No. Nota        : " + noNota);
        inputPerdana();
        inputJumlah();
        setTotJual();
        inputJenis();
        setKetByr();
        if(jnsByr == 2){
            inputWktTmp();
        }
        setPPN();
        setBunga();
        hitungJual();
        setSouvenir();
    }

    void inputJumlah() {
        System.out.print("Jml. Jual     : ");
        jmlJual = input.nextInt();
    }

    void setTotJual() {
        totJual = hrgJual * jmlJual;
        System.out.println("Total       : " + totJual);
    }

    int getHargaJual() {
        return hrgJual;
    }

    void inputJenis() {
        System.out.print("Jenis Bayar   : ");
        jnsByr = input.nextInt();
    }

    void setKetByr() {
        if(jnsByr==1){
            ketByr = "Cash";
        }else {
            ketByr = "Tempo";
        }
        System.out.println("Ket. Bayar    : " + ketByr);
    }

    void inputWktTmp() {
        System.out.print("Waktu Tempo     : ");
        wktTmp = input.nextInt();
    }

    void setPPN(){
        ppn = totJual*11/100;
        System.out.println("PPN           : " + ppn);
    }

    void setBunga() {
        if(wktTmp >= 1) {
            bunga = totJual*5/100;
        }else{
            bunga = 0;
        }
        System.out.println("Bunga          : " + bunga);
    }

    void hitungJual() {
        totByr = totJual + ppn - bunga;
        System.out.println("Total Bayar     : " + totByr);
    }
    public void setSouvenir() {
        if(jnsByr==1) {
            if(totByr>100000 && totByr<500000){
                souvenir = "Mug";
            }else if(totByr>500000 && totByr<750000){
                souvenir = "Payung";
            }else if(totByr>750000 && totByr<1000000){
                souvenir = "Tas";
            }else if(totByr>1000000){
                souvenir = "Voucher 100rb";
            }else {
                souvenir = "Maaf anda tidak dapat souvenir";
            }
        }else {
            souvenir = "Maaf anda tidak dapat souvenir";
        }
        System.out.printf("Souvenir         : " + souvenir);
    }

    public void cetak() {
        System.out.printf("%-10s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                noNota, barCode, nmKartu, getHargaJual(), jmlJual, totJual, ketByr, ppn, bunga, totByr, souvenir);
    }
}