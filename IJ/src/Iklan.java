import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.util.Scanner;

import java.util.Scanner;

public class Iklan {
    String nmIklan;
    int kodeIklan, tarifIklan;
    Scanner input = new Scanner(System.in);
    public void inputIklan() {
        System.out.print("Kode Produk   : ");
        kodeIklan = input.nextInt();
        if(kodeIklan==1) {
            nmIklan = "Iklan Baris";
            tarifIklan = 20000;
        }else if(kodeIklan==2) {
            nmIklan = "Iklan Display";
            tarifIklan = 25000;
        }else {
            nmIklan = "";
        }
        System.out.println("Produk Iklan : " + nmIklan);
        System.out.println("Tarif Iklan  : " + tarifIklan);
    }
}


class PasangIklan extends Iklan {
    int noNota, jmlIklan, durasi, diskon, biayaIklan, ppn, totBiaya;
    String nama, alamat, souvenir;
    Scanner input = new Scanner(System.in);

    public void pasangIklan(String cabang) {
        System.out.println("Iklan Cetak - " + cabang + "\n");
    }

    public void setNota() {
        System.out.println("No. Nota           : " + noNota++);
        System.out.print("Nama Pemasang      : ");
        nama = input.next();
        System.out.print("Alamat             : ");
        alamat = input.next();
        inputIklan();
        inputJumlah();
        inputDurasi();
        setDiskon();
        setBiayaIklan();
        ppn = biayaIklan*10/100;
        System.out.println("PPN             : " + ppn);
        setTotal();
        setSouvenir();
        noNota++;
    }

    public void inputJumlah() {
        if(kodeIklan==1) {
            System.out.print("Jml. Baris  : ");
            jmlIklan = input.nextInt();
        }else if(kodeIklan==2) {
            System.out.print("Luas (mmk)  : ");
            jmlIklan = input.nextInt();
        }
    }

    public void inputDurasi() {
        System.out.print("Durasi (hari)    : ");
        durasi = input.nextInt();
    }

    public void setDiskon() {
        System.out.print("Diskon (%)       : ");
        diskon = input.nextInt();
    }

    public void setBiayaIklan() {
        biayaIklan = tarifIklan*jmlIklan*durasi - (tarifIklan*diskon/100);
        System.out.println("Biaya Iklan     : " + biayaIklan);
    }

    public void setSouvenir() {
        if(durasi>=3 && durasi<=6) {
            souvenir = "Mug";
        }else if(durasi>=7 && durasi<=10) {
            souvenir = "Payung";
        }else if(durasi>=11 && durasi<=14) {
            souvenir = "Tas";
        }else {
            souvenir = "Maaf anda tidak dapat souvenir";
        }
        System.out.printf("Souvenir         : " + souvenir);
    }

    public void setTotal() {
        totBiaya = biayaIklan + ppn;
        System.out.println("Total Biaya     : " + totBiaya);
    }

    public int getTarifIklan() {
        return tarifIklan*jmlIklan;
    }

    public int getDiskon() {
        return diskon;
    }

    public int getBiayaIklan() {
        return biayaIklan;
    }

    public String getSouvenir() {
        return souvenir;
    }

    public int getTotal() {
        return totBiaya;
    }

    public void cetak() {
        System.out.printf("%-10s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                noNota, nama, alamat, nmIklan, jmlIklan, durasi, getTarifIklan(), getDiskon(), getBiayaIklan(), getTotal(), getSouvenir());
    }
}