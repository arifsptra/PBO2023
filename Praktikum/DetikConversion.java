class DetikConversion {
    int detik=0;
    // conversion from hours to seconds
    public int jam(int jam){
        detik = (jam*60)*60;
        return detik;
    }

    public int menit(int menit){
        detik = menit*60;
        return detik;
    }
}
