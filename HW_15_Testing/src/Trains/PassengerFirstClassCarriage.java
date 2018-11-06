package Trains;

public class PassengerFirstClassCarriage extends Carriage {
    public static final String PASSENGER_CLASS_1 = "passngr:1cl";
    public static final int MAX_LOAD = 100; // Number of places

    public PassengerFirstClassCarriage() {
        this.type = PASSENGER_CLASS_1;
        this.maxLoad = MAX_LOAD;
        this.load = this.generateRandomLoad();
    }

    @Override
    public String toString() {
        return "[:" + this.type + ":" + "1:" + this.load + "]";
    }
}
