package Trains;

import java.util.Random;

public class Carriage {
    public static final int MIN_LOAD = 1;
    public int load;
    public String type;
    public int maxLoad = 1;

    public int generateRandomLoad() {
        return new Random().nextInt(this.maxLoad) + MIN_LOAD;
    }
}
