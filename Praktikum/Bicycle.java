public class Bicycle {
    int speed=0;
    int gear=0;
    // method
    void changeGear(int newValue) {
        gear+=newValue;
        System.out.println("\nGear: " + gear);
    }
    void speedUp(int increment) {
        speed+=increment;
        System.out.println("\nSpeed: " + speed);
    }
}
