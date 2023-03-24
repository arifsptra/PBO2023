class Luar {
    void cetakLuar(){
        System.out.println("Cetak Luar...");
        // cetakTengah() --> error
        // cetakDalam() --> error
    }    
    class Tengah {
        void cetakTengah(){
            cetakLuar();
            System.out.println("Cetak Tengah...");
            // cetakDalam() --> error
        }
        class Dalam {
            void cetakDalam(){
                cetakLuar();
                cetakTengah();
                System.out.println("Cetak Dalam...");
            }
        }
    }
}
