import java.util.Scanner;

public class MatrixCalculator {
    int n;
    int[][] mA, mB, result;
    Scanner input = new Scanner(System.in);
    public void menu() {
        System.out.println("");
        char menu;
        System.out.println("1. Input Matrix");
        System.out.println("2. Cetak Matrix");
        System.out.println("3. Tambah");
        System.out.println("4. Kurang");
        System.out.println("5. Kali");
        System.out.println("6. Bagi");
        System.out.println("7. Exit");

        System.out.print("Pilih [1-7]: ");
        menu = input.next().charAt(0);
        System.out.println("");
        switch(menu) {
            case '1': input();
            menu();
            case '2': cetak();
            menu();
            case '3': tambah();
            menu();
            case '4': kurang();
            menu();
            case '5': kali();
            menu();
            case '6': bagi();
            menu();
            case '7': System.exit(menu);
        }
    }

    public void input() {
        System.out.print("Input Orde Matrix: ");
        n = input.nextInt();

        mA = new int[n][n];
        mB = new int[n][n];
        result = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print("Input matrix A ["+i+","+j+"] : ");
                mA[i][j] = input.nextInt();
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print("Input matrix B ["+i+","+j+"] : ");
                mB[i][j] = input.nextInt();
            }
        }
    }

    public void cetak() {
        System.out.println("Matrix A");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(mA[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("Matrix B");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(mB[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void tambah() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                result[i][j] = mA[i][j] + mB[i][j];
            }
        }

        // cetak hasil pertambahan
        System.out.println("Hasil Pertambahan: ");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void kurang() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                result[i][j] = mA[i][j] - mB[i][j];
            }
        }

        // cetak hasil pengurangan
        System.out.println("Hasil Pengurangan: ");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void kali() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                result[i][j] = mA[i][j] * mB[i][j];
            }
        }

        // cetak hasil perkalian
        System.out.println("Hasil Perkalian: ");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void bagi() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                result[i][j] = mA[i][j] / mB[i][j];
            }
        }

        // cetak hasil pembagian
        System.out.println("Hasil Pembagian: ");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
