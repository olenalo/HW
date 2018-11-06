package Trains;

public class Demo {

    public static void main(String[] args) {
        Train train = new Train(2, 1, 3);
        // Train train = new Train(5, 0, 0);
        // Train train = new Train(0, 2, 0);
        // Train train = new Train(0, 0, 4);

        train.setItinerary("Kharkiv", "Kyiv");

        train.addCarriages();

        System.out.println(train);
    }
}
