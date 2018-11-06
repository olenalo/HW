package Trains;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarriageTest {

    private Carriage carriage;

    @Before
    public void setUp() {
        carriage = new Carriage();
    }

    @Test
    public void generateRandomLoadSuccessTest() {
        assertTrue(carriage.generateRandomLoad() <= carriage.maxLoad);
        assertTrue(carriage.generateRandomLoad() >= Carriage.MIN_LOAD);
    }
}
