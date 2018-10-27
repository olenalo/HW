import java.util.Random;

public class Conference {

    public static String currency = "USD";

    private String title;
    private String organizer;
    private String[] workshops;
    private String[] talks;
    private double price;

    @Override
    public String toString() {
        return this.title;
    }

    public Conference(String title, String organizer, double price) {
        this.title = title;
        this.organizer = organizer;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getWorkshops() {
        return this.workshops;
    }

    public void setWorkshops(String[] workshops) {
        this.workshops = workshops;
    }

    public String[] getTalks() {
        return this.talks;
    }

    public void setTalks(String[] talks) {
        this.talks = talks;
    }

    public String getOrganizer() {
        return this.organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String showPrice() {
        return this.price + " " + currency;
    }

    public static Boolean checkArrayContains(String[] array, String value) {
        for (String v: array) {
            // FIXME: NullPointerException could occur here
            // because `v` can be null, after being assigned during array initialization
            if (v.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public String[] pickFreeTicketsWinners(String[] candidates, int winnersNumber) throws IllegalArgumentException {
        if (winnersNumber > candidates.length) {
            throw new IllegalArgumentException("Winners number should be smaller than candidates'");
        }
        String[] winners = new String[winnersNumber];
        Random random = new Random();
        for (int i = 0; i < candidates.length; i++) {
            int n = random.nextInt(candidates.length);
            // Exclude a candidate who already won
            if (!checkArrayContains(winners, candidates[n])) {
                // FIXME: ArrayIndexOutOfBoundsException occurs here
                // because we continue iterating even when `i` is bigger than `winner`'s length
                // FIXME: also, prevent possible NullPointerException (no value should be `null`)
                winners[i] = candidates[n];
            }
        }

        return winners;
    }



}
