public class MatrixExample {
    public static void main(String[] args) {
        int array[][] = {{1,3,5},{2,4,6},{9,2,3},{4,1,0}};

        System.out.println("Row size: " + array.length);
        System.out.println("Column size: " + array[1].length);
        outputArray(array);
    };

    static void outputArray(int[][] array) {
        int rowSize = array.length;
        int columnSize = array[1].length;
        for(int i=0; i<rowSize; i++) {
            System.out.print("[");
            for(int j=0; j<columnSize; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println(" ]");
        }
    }
}
