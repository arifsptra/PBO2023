public class BicycleDemo {
    public static void main(String[] args) {
        // create object
        Bicycle bike = new Bicycle();

        // call attribute and give value
        bike.speed = 5;
        bike.gear = 10;

        // call method and pointing parameter value
        bike.speedUp(11);
        bike.changeGear(9);
    }
}
