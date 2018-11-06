package Trains;

public class LocomotiveCarriage extends Carriage {
    public static final String LOCOMOTIVE = "locomotive";
    public static final int MAX_LOAD = 1; // Doesn't apply for locomotive, but should be positive...

    public LocomotiveCarriage() {
        this.type = LOCOMOTIVE;
        this.maxLoad = MAX_LOAD;
        this.load = this.generateRandomLoad();
    }

    @Override
    public String toString() {
        return "<:" + this.type + ":]";
    }
}
