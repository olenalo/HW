package Trains;

public class PassengerSecondClassTitleCarriage extends Carriage {
    public static final String PASSENGER_CLASS_2 = "passngr:2cl";
    public static final int MAX_LOAD = 200;  // Number of places

    public PassengerSecondClassTitleCarriage() {
        this.type = PASSENGER_CLASS_2;
        this.maxLoad = MAX_LOAD;
        this.load = this.generateRandomLoad();
    }

    @Override
    public String toString() {
        return "[:" + this.type + ":" + "1:" + this.load + "]";
    }
}
