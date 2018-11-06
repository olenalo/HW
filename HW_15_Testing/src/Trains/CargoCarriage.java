package Trains;

public class CargoCarriage extends Carriage {
    public static final String CARGO = "cargo";
    public static final int MAX_LOAD = 100; // Percentage

    public CargoCarriage() {
        this.type = CARGO;
        this.maxLoad = MAX_LOAD;
        this.load = this.generateRandomLoad();
    }

    @Override
    public String toString() {
        return "[:" + this.type + ":" + this.load + "%" +  "]";
    }
}
