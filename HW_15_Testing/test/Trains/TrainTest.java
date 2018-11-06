package Trains;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrainTest {

    private Train train;
    private Train emptyTrain;

    public static boolean checkArrayIsEmpty(Object arr[]) {
        boolean empty = true;
        for (Object ob: arr) {
            if (ob != null) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    public static boolean checkAllReferencesUnique(Object arr[]) {
        if (checkArrayIsEmpty(arr)) {
            throw new IllegalArgumentException("Can check only non-empty array.");
        }
        boolean unique = true;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                if (arr[i] == arr[i-1]) {
                    unique = false;
                    break;
                }
            }
        }
        return unique;
    }

    @Before
    public void setUp() {
        train = new Train(1, 2, 2);
        train.setItinerary("Kharkiv", "Kyiv");
        train.addCarriages();

        emptyTrain = new Train(0, 0, 0);
        emptyTrain.addCarriages();
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTrainTestShouldFailIfNegativePass1ClNumber() {
        new Train(-1, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTrainTestShouldFailIfNegativePass2ClNumber() {
        new Train(0, -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTrainTestShouldFailIfNegativeCargoNumber() {
        new Train(0, 0, -1);
    }

    @Test
    public void toStringTest() {
        Assert.assertThat(train.toString(), CoreMatchers.containsString(train.departurePlace));
        Assert.assertThat(train.toString(), CoreMatchers.containsString(train.destinationPlace));
        Assert.assertThat(train.toString(), CoreMatchers.containsString("<:locomotive:]"));
        Assert.assertThat(train.toString(), CoreMatchers.containsString("[:passngr:2cl:"));
        Assert.assertThat(train.toString(), CoreMatchers.containsString("[:passngr:1cl:"));
        Assert.assertThat(train.toString(), CoreMatchers.containsString("[:cargo:"));
    }

    @Test
    public void updateDescriptionTestSuccess() {
        assertEquals(StringUtils.countMatches(train.toString(), "[:passngr:1cl:"), 1);
        assertEquals(StringUtils.countMatches(train.toString(), "[:passngr:2cl:"), 2);
        assertEquals(StringUtils.countMatches(train.toString(), "[:cargo:"), 2);
        // No trailing "=" FIXME (e.g. should fail for "]")
        assertNotEquals("=", train.toString().charAt(train.toString().length() - 1));
    }

    @Test
    public void describeTrainSchemeTestSuccess() {
        assertEquals(StringUtils.countMatches(train.toString(), "<:locomotive:]"), 1);
        assertEquals(StringUtils.countMatches(train.toString(), "[:passngr:1cl:"), 1);
        assertEquals(StringUtils.countMatches(train.toString(), "[:passngr:2cl:"), 2);
        assertEquals(StringUtils.countMatches(train.toString(), "[:cargo:"), 2);
    }

    @Test
    public void describeTrainSchemeTestLocomotiveAlwaysPresent() {
        // Zero number of other carriages
        assertEquals(StringUtils.countMatches(emptyTrain.toString(), "<:locomotive:]"), 1);
    }

    @Test
    public void addCarriagesTestSuccess() {
        // assertTrue(ArrayUtils.isNotEmpty(train.carriages));  // misleading docs https://stackoverflow.com/a/21254598
        assertFalse(checkArrayIsEmpty(train.carriages));
        // Ensure carriages of each type are different objects (check references)
        assertTrue(checkAllReferencesUnique(train.carriages));
    }

    @Test
    public void removeAllCarriagesTestSuccess() {
        train.removeAllCarriages();
        // assertTrue(ArrayUtils.isEmpty(train.carriages)); // misleading docs https://stackoverflow.com/a/21254598
        assertTrue(checkArrayIsEmpty(train.carriages));
    }

    @Test
    public void setItineraryTestSuccess() {
        assertEquals("Kharkiv", train.departurePlace);
        assertEquals("Kyiv", train.destinationPlace);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setItineraryTestShouldFailIfPlacesEqual() {
        train.setItinerary("Kyiv", "Kyiv");
        assertEquals("Kharkiv", train.departurePlace);
        assertEquals("Kyiv", train.destinationPlace);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setItineraryTestShouldFailIfDeparturePlaceNotInList() {
        train.setItinerary("Lviv", "Kyiv");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setItineraryTestShouldFailIfDestinationPlaceNotInList() {
        train.setItinerary("Kyiv", "Lviv");
    }
}
